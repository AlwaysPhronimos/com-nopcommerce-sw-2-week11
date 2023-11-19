package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.linkText("Log in")).click();

        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        String actualWelcomeMessage = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedWelcomeMessage, actualWelcomeMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // click on login link
        driver.findElement(By.linkText("Log in")).click();
        // enter email
        driver.findElement(By.id("Email")).sendKeys("kaise.a.kaisej@gmail.com");
        //enter password
        driver.findElement(By.name("Password")).sendKeys("silly1234");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        String expectedLogout = "Log out";
        String actualLogout = driver.findElement(By.linkText("Log out")).getText();
        Assert.assertEquals(expectedLogout, actualLogout);
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("prime123@gmail.com");
        //enter password
        driver.findElement(By.name("Password")).sendKeys("prime1234");

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again. No customer account found";

        //Find the errorMessage element and get the text
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

