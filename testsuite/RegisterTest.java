package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    static String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test

    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("gender-female")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("FirstName")).sendKeys("Any");
        Thread.sleep(5000);
        driver.findElement(By.id("LastName")).sendKeys("Body");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//option[@value='8'])[1]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//option[@value='7'])[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//option[@value='1982']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("Email")).sendKeys("kaise.a.kaisej@gmail.com");
        //enter password
        driver.findElement(By.name("Password")).sendKeys("silly1234");
        Thread.sleep(5000);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("silly1234");
        Thread.sleep(5000);
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(5000);
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(5000);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
