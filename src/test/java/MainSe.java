
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import pageObjects.DemoQAPage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MainSe {

    @DataProvider(name = "myFirstDataProvider")
    public Object[][] myFirstDataProvider() {
        return new Object[][]{
                {"/elements"},
                {"/forms"},
                {"/alertsWindows"},
                {"/widgets"},
                {"/interaction"},
                {"/books"}
        };
    }

    private static void windowHandlers() {
        ChromeDriver driver = null;
        try {
            driver = WebdriverManager.getChromeDriverByManager();
            driver.get("https://demoqa.com/browser-windows");
            DemoQAPage demoQAPage = new DemoQAPage(driver);
            demoQAPage.getNewTabButton().click();
            String parentWindow = driver.getWindowHandle();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String window : windowHandles) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());
            driver.close();
            driver.switchTo().window(parentWindow);
            driver.findElement(By.id("windowButton")).click();
            Set<String> windowHandles2 = driver.getWindowHandles();
            for (String window : windowHandles2) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            System.out.println(driver.findElement(By.id("sampleHeading")).getText());
            driver.close();

            System.out.println("Page closed");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static void radioButton() {
        ChromeDriver driver = WebdriverManager.getChromeDriverByManager();
        driver.get("https://demoqa.com/radio-button");
        DemoQAPage demoQAPage = new DemoQAPage(driver);
        demoQAPage.getYesButton();
//        yesButton.click();
        demoQAPage.getNoRadioButton();
        System.out.println("YesRadioButton before click: isEnabled " + demoQAPage.getYesButton().isEnabled() + ", isSelected: " + demoQAPage.getYesButton().isSelected());
        System.out.println("NoRadioButton before click: isEnabled " + demoQAPage.getNoRadioButton().isEnabled() + ", isSelected: " + demoQAPage.getNoRadioButton().isSelected());
        driver.executeScript("arguments[0].click()", demoQAPage.getYesButton());
        driver.executeScript("arguments[0].click()", demoQAPage.getNoRadioButton());
        System.out.println("YesRadioButton after click: isEnabled " + demoQAPage.getYesButton().isEnabled() + ", isSelected: " + demoQAPage.getYesButton().isSelected());
        System.out.println("NoRadioButton after click: isEnabled " + demoQAPage.getNoRadioButton().isEnabled() + ", isSelected: " + demoQAPage.getNoRadioButton().isSelected());
        driver.close();
        driver.quit();
    }

    private static void alert() throws InterruptedException {
        ChromeDriver driver = WebdriverManager.getChromeDriverByManager();
        driver.get("https://demoqa.com/alerts");
        DemoQAPage demoQAPage = new DemoQAPage(driver);
        demoQAPage.getFirstButtonAlert().click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        demoQAPage.getSecondButtonAlert().click();
        Thread.sleep(5000);
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        demoQAPage.getThirdButtonAlert().click();
        Alert alert2 = driver.switchTo().alert();
//      alert2.accept();
        alert2.dismiss();
        driver.manage().window().maximize();
        demoQAPage.getFourthButtonAlert().click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Eliza");
        alert3.accept();
        driver.quit();
    }

    private static void simpleClick() {
        ChromeDriver driver = WebdriverManager.getChromeDriverByManager();
        driver.get("https://demoqa.com/buttons");
        driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
        driver.quit();
    }

    private static void actionsClass() throws IOException {
        ChromeDriver driver = null;
        try {
            driver = WebdriverManager.getChromeDriverByManager();
            driver.get("https://demoqa.com");
            DemoQAPage demoQAPage = new DemoQAPage(driver);
            List<WebElement> cards = demoQAPage.getCards();
            WebElement sixthCards = cards.get(5);
            Actions actions = new Actions(driver);
            actions.moveToElement(sixthCards).build().perform();
            sixthCards.click();
            throw new NoSuchElementException("Exceptie custom");
        } catch (Exception e) {
            System.out.println("Am intrat in ramura catch");
            if (driver != null) {
                File file = driver.getScreenshotAs(OutputType.FILE);
                File destinationFile = new File("/Users/mr.lee/Desktop/poza.png");
                FileUtils.copyFile(file, destinationFile);
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
        System.out.println("Page closed");
    }
}


