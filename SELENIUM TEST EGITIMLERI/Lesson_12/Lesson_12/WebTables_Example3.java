package Lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables_Example3 {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/web-table-element.php");
    }

    @Test
            public void Dynamictable(){
    WebElement baseTable = driver.findElement(By.tagName("table"));

    //To find third row of table
    WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
    String rowtext = tableRow.getText();
		 System.out.println("Third row of table : "+rowtext);


    //to get 3rd row's 2nd column data
    WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed);
}
}
