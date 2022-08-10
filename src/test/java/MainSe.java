import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class MainSe {
    public static void main(String[] args) throws InterruptedException {

    }

    public static void windowHandle() {
        ChromeDriver driver = null;
        try {
            driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/browser-windows");

            WebElement newTabButton = driver.findElement(By.id("tabButton"));
            newTabButton.click();

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
            } finally{
                if (driver != null) {
                    driver.quit();
                }
            }
        }
        public static void radioButton () {
            ChromeDriver driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/radio-button");
//        WebElement yesButton = driver.findElement(By.cssSelector("label[for='yesRadio']"));
            WebElement yesButton = driver.findElement(By.id("yesRadio"));
//        yesButton.click();
            WebElement noRadioButton = driver.findElement(By.id("noRadio"));

            System.out.println("YesRadioButton before click: isEnabled " + yesButton.isEnabled() + ", isSelected: " + yesButton.isSelected());
            System.out.println("NoRadioButton before click: isEnabled " + noRadioButton.isEnabled() + ", isSelected: " + noRadioButton.isSelected());
            driver.executeScript("arguments[0].click()", yesButton);
            driver.executeScript("arguments[0].click()", noRadioButton);
            System.out.println("YesRadioButton after click: isEnabled " + yesButton.isEnabled() + ", isSelected: " + yesButton.isSelected());
            System.out.println("NoRadioButton after click: isEnabled " + noRadioButton.isEnabled() + ", isSelected: " + noRadioButton.isSelected());

            driver.close();
            driver.quit();
        }
        public static void alert () throws InterruptedException {
            ChromeDriver driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/alerts");

            WebElement firstButtonAlert = driver.findElement(By.id("alertButton"));
            firstButtonAlert.click();
            Alert alert = driver.switchTo().alert();
            alert.accept();

            WebElement secondButtonAlert = driver.findElement(By.id("timerAlertButton"));
            secondButtonAlert.click();
            Thread.sleep(5000);
            Alert alert1 = driver.switchTo().alert();
            alert1.accept();

            WebElement thirdButtonAlert = driver.findElement(By.cssSelector("#confirmButton"));
            thirdButtonAlert.click();
            Alert alert2 = driver.switchTo().alert();
//      alert2.accept();
            alert2.dismiss();

            driver.manage().window().maximize();
            WebElement fourthButtonAlert = driver.findElement(By.cssSelector("#promtButton"));
            fourthButtonAlert.click();
            Alert alert3 = driver.switchTo().alert();
            alert3.sendKeys("Eliza");
            alert3.accept();
            driver.close();
        }
        public static void doubleClick () {
            ChromeDriver driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/buttons");
            WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClick).perform();
            driver.close();
        }
        public static void rightClick () {
            ChromeDriver driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/buttons");
            WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
            Actions actions = new Actions(driver);
            actions.contextClick(rightClick).perform();
            driver.close();
        }

        public static void simpleClick () {
            ChromeDriver driver = getChromeDriverByManager();
            driver.get("https://demoqa.com/buttons");
            driver.findElements(By.cssSelector(".btn.btn-primary")).get(2).click();
            driver.close();
        }
        public static void actionsClass () throws IOException {
            ChromeDriver driver = null;
            try {
                driver = getChromeDriverByManager();

                driver.get("https://demoqa.com");
                List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
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

        public static ChromeDriver getChromeDriverByExecutable () {
            System.setProperty("webdriver.chrome.driver", "src/test/chromedriver");
            return new ChromeDriver();
        }

        private static ChromeDriver getChromeDriverByManager () {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }

