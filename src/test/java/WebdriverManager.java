import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverManager {
    public static ChromeDriver getChromeDriverByExecutable() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver");
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverByManager() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
