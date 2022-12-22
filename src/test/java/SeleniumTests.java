import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.DemoQAPage;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class SeleniumTests {

    ChromeDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebdriverManager.getChromeDriverByManager();
    }

    @Test(dataProvider = "myFirstDataProvider", dataProviderClass = MainSe.class)
    public void dataProviderTest(String path) {
        driver.get("https://demoqa.com" + path);
        DemoQAPage demoQAPage = new DemoQAPage(driver);
        demoQAPage.getImage();
//        assertTrue(demoQAPage.getImage().isDisplayed(), "Image is not displayed");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void assertTest() {
        driver.get("https://demoqa.com/");
        DemoQAPage demoQAPage = new DemoQAPage(driver);
        List<WebElement> cards = demoQAPage.getCards();
        assertEquals(cards.size(), 6, "Wrong card size");
    }

    @Test
    public void primulTestNG() {
        driver.get("https://demoqa.com/browser-windows");
//      throw new RuntimeException("Custom exception");
    }

    @Test
    public void doubleClick() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        assertEquals(message.getText(), "You have done a double click", "Unsuccessful double click");
    }

    @Test
    public void rightClick() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://demoqa.com/buttons");
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        softAssert.assertTrue(rightClick.isDisplayed(), "Right click button is not displayed");
        Actions actions = new Actions(driver);
        actions.contextClick(rightClick).perform();
        WebElement message = driver.findElement(By.id("rightClickMessage"));
        softAssert.assertEquals(message.getText(), "You have done a right click", "Unsuccessful right click");
        softAssert.assertAll();
    }
}

