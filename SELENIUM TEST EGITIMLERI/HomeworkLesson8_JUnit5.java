package Lesson_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkLesson8_JUnit5 {
    static WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

}
    //1. Verify successful login after trying with valid user credentials.
    @Test
    public void validCredentialsLogin(){
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement postTitleElement = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));

        String postTitleElementText = postTitleElement.getText();

        String expectedPostTitleText = "Logged In Successfully";


        WebElement postContentElement = driver.findElement(By.cssSelector(".has-text-align-center strong"));

        String postContentText = postContentElement.getText();

        String expectedPostContentText = "Congratulations student. You successfully logged in!";

        System.out.println("Post Title Element Text is: " + postTitleElementText);
        System.out.println("Post Content Text is: " + postContentText);
        Assertions.assertEquals(expectedPostTitleText,postTitleElementText);
        Assertions.assertEquals(expectedPostContentText,postContentText);
    }

    // 2. Verify error message is shown after trying with invalid username.
    @Test
    public void invalidUsernameAndValidPasswordLogin(){
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("inValidUsername");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();

        System.out.println("Error message is: " + errorMessageElementText);


        String expectedErrorMessageElementText = "Your username is invalid!";

        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your username is invalid!");

        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();


        System.out.println("boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);


        Assertions.assertEquals(expectedErrorMessageElementText, errorMessageElementText);

        Assertions.assertTrue(firstErrorMessageElementCondition,"Please check first boolean");

        Assertions.assertTrue(secondErrorMessageElementCondition,"Please check second boolean");

        System.out.println("location" + errorMessageElement.getLocation());

    }

    //3. Verify error message is shown after trying with invalid password.
    @Test
    public void validUsernameAndInValidPasswordLogin(){
        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("InvalidPassword");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessageElementText = errorMessageElement.getText();

        System.out.println("Error message is: " + errorMessageElementText);


        String expectedErrorMessageElementText = "Your password is invalid!";

        boolean firstErrorMessageElementCondition = errorMessageElementText.contains("Your password is invalid!");

        boolean secondErrorMessageElementCondition = errorMessageElement.isDisplayed();


        System.out.println("boolean Condition of text contains is: " + firstErrorMessageElementCondition);
        System.out.println("boolean Condition of element is Displayed: " + secondErrorMessageElementCondition);



        Assertions.assertEquals(expectedErrorMessageElementText, errorMessageElementText);

        Assertions.assertTrue(firstErrorMessageElementCondition,"Please check first boolean");

        Assertions.assertTrue(secondErrorMessageElementCondition,"Please check second boolean");

        System.out.println("location" + errorMessageElement.getLocation());

    }

    //4. Verify page title is shown as expected on login page.
    @Test
    public void validatePageTitleOnLoginPage(){
        String titleOfLoginPage = driver.getTitle();
        System.out.println("Title Of the Login Page is: " + titleOfLoginPage);

        boolean titleOfLoginPageCondition = titleOfLoginPage.contains("Test Login | Practice Test Automation");

        String expectedTitleOfLoginPage = "Test Login | Practice Test Automation";

        Assertions.assertEquals(expectedTitleOfLoginPage,titleOfLoginPage);

        Assertions.assertTrue(titleOfLoginPageCondition,"Please check the title of the login page");
    }

    //5. Verify page title is shown as expected after trying with valid user credentials.
    @Test
    public void verifyPageTitleAfterLoginWithValidCredentials(){
        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String titleOfLoggedInPage = driver.getTitle();
        System.out.println("Title Of the Logged In Page: " + titleOfLoggedInPage);

        boolean titleOfLoggedInPageCondition = titleOfLoggedInPage.contains("Logged In Successfully | Practice Test Automation");

        String expectedTitleOfLoginPage = "Logged In Successfully | Practice Test Automation";

        Assertions.assertEquals(expectedTitleOfLoginPage,titleOfLoggedInPage);

        Assertions.assertTrue(titleOfLoggedInPageCondition,"Please check the title of the logged in page");
    }

    //6. Verify user can logout after logging with valid credentials.
    @Test
    public void verifyUserCanLogoutAfterLoggedIn(){

        String titleOfLoginPage = driver.getTitle();
        System.out.println("Title Of the Login Page: " + titleOfLoginPage);
        Assertions.assertEquals("Test Login | Practice Test Automation",titleOfLoginPage);

        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys("student");

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        //System.out.println("Username Field is displayed on Login page: " + usernameFieldElement.isDisplayed());

        String titleOfLoggedInPage = driver.getTitle();
        System.out.println("Title Of the Logged In Page: " + titleOfLoggedInPage);

        Assertions.assertEquals("Logged In Successfully | Practice Test Automation", titleOfLoggedInPage);

        WebElement logOutButton = driver.findElement(By.cssSelector("a[class^='wp-block-button']"));
        logOutButton.click();

        String titleOfLoginPageAfterLogout = driver.getTitle();
        System.out.println("Title Of the Logged In Page: " + titleOfLoginPageAfterLogout);

        String ExpectedTitleOfLoginPageAfterLogout = "Test Login | Practice Test Automation";

        Assertions.assertEquals(ExpectedTitleOfLoginPageAfterLogout,titleOfLoginPageAfterLogout);

        WebElement TestloginTextElement = driver.findElement(By.xpath("//h2"));
        System.out.println("Login page has header 2: " + TestloginTextElement.getText());

        Assertions.assertEquals("Test login",TestloginTextElement.getText());
    }
    @AfterEach
    public void tearDown(){
        driver.quit();

    }
}
