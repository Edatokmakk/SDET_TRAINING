package Lesson_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Utilities_BrowserUtils {

    private static WebDriver driver;

    @BeforeClass
    public static WebDriver startBrowser(String browserType, String url) {
        if (browserType.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    @AfterClass
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
