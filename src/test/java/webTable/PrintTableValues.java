package webTable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrintTableValues {

    WebDriver driver;

    @Test
    void tableValues(){

        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
        List rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("Total no of row " + rows_count);
        List column_table = table.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[1]/td"));
        int collum_count = column_table.size();
        System.out.println("Total no of column " + collum_count);
        List column1 = table.findElements(By.tagName("th"));
        int table_header = column1.size();
        System.out.println("Structure value is " + table_header);
        String value =driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]")).getText();
        System.out.println("Value of total column "+value);

        for (int i = 1; i <=rows_count;i++){

            //Used for loop for number of columns.
            for (int j = 1; j <=collum_count;j++){

                String Table_data = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+i+"]/td["+j+"]")).getText();
                System.out.print(Table_data + " ");
            }

            System.out.println("");
            System.out.println("");

        }

    }


    @BeforeTest
    void openurl(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    void closeBrowser(){
        driver.close();
    }
}
