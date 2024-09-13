package Lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables_Example2 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }
    @Test
        public void numberOfColAndRows() {
            //No.of Columns
            List<WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
            System.out.println("No of cols are : " + col.size());
            //No.of rows
            List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
            System.out.println("No of rows are : " + rows.size());
            driver.close();
        }
    }

