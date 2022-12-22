import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.EmagPage;
import java.time.Duration;
import static org.testng.Assert.assertTrue;
import static pageObjects.EmagPage.*;

public class ChromeOptionsTests {
   ChromeDriver driver;

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void mobileTest() {
        ChromeDriver driver = WebdriverManager.getChromeDriverWithOptions();
        driver.get("https://demoqa.com/");
        driver.quit();
    }

    @Test
    public void implicitWaitTest() throws InterruptedException {
        driver = WebdriverManager.getChromeDriverWithOptions();
        driver.get("https://www.emag.ro/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        EmagPage emagPage = PageFactory.initElements(driver, EmagPage.class);
        Thread.sleep(3000);
        WebElement closeButton = driver.findElement(By.cssSelector("button.close"));
        closeButton.click();
        emagPage.getAcceptButton().click();
        Thread.sleep(2000);
        emagPage.getLoginButton().click();
    }

    @Test
    public void explicitWaitTest() throws InterruptedException {
        driver = WebdriverManager.getChromeDriverWithOptions();
        driver.get("https://www.emag.ro/");
        EmagPage emagPage = new EmagPage(driver);
//      exemplu Webdriver wait
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//      exemplu Fluent wait
        FluentWait<ChromeDriver>  wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CLOSE_BUTTON_CSS)));
//        wait.until(ExpectedConditions.visibilityOf(emagPage.getCloseButton()));
//        emagPage.getCloseButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ACCEPT_BUTTON_CSS)));
        wait.until(ExpectedConditions.elementToBeClickable(emagPage.getAcceptButton()));
        Thread.sleep(2000);
        emagPage.getAcceptButton().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LOGIN_BUTTON_CSS)));
        emagPage.getLoginButton().click();
        assertTrue(driver.getCurrentUrl().contains("user/login"), "Login page did not open");
    }
}
