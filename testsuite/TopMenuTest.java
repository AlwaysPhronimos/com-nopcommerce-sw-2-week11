package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    static String baseurl= "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseurl);
    }
    @Test
    public void userShouldNavigateToComputerPageSuccessfully(){
        WebElement computersTab = driver.findElement(By.xpath("//a[contains(text(), 'Computers')][1]"));
        computersTab.click();
        String expectedText = "Computers";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully(){
        WebElement electronicsTab = driver.findElement(By.xpath("(//a[contains(text(),'Electronics')])[1]"));
        electronicsTab.click();
        String expectedText = "Electronics";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToApparelPageSuccessfully(){
        WebElement apparelTab = driver.findElement(By.xpath("(//a[contains(text(),'Apparel')])[1]"));
        apparelTab.click();
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully(){
        driver.findElement(By.xpath("(//a[contains(text(),'Digital downloads')])[1] ")).click();
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully(){
        driver.findElement(By.xpath("((//a[contains(text(),'Books')])[1] ")).click();
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("(//a[contains(text(),'Jewelry')])[1] ")).click();
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("(//a[contains(text(),'Gift Cards ')])[1]")).click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
