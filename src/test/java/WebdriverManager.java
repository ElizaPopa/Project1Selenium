import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class WebdriverManager {
    public static ChromeDriver getChromeDriverByExecutable() {
        System.setProperty("webdriver.chrome.driver", "src/test/chromedriver");
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverByManager() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static ChromeDriver getChromeDriverWithOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, String> map = new HashMap<>();
        map.put("deviceName", "iPhone X");
//        chromeOptions.addArguments("start-maximized");
//        chromeOptions.setExperimentalOption("mobileEmulation", map);
//        chromeOptions.setAcceptInsecureCerts(true);
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }
}
