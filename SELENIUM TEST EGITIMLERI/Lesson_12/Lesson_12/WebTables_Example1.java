package Lesson_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTables_Example1 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

    }
    @Test
    public void findFirstColumn(){
        WebElement firstColumn = driver.findElement(By.xpath("//div[contains(text(),'Cierra')]"));
        System.out.println(firstColumn.getText());
    }
}
