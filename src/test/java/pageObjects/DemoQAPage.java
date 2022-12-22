package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DemoQAPage {

    public static final String NEWTAB_BUTTON_ID = "tabButton";
    public static final String YES_BUTTON_ID = "yesRadio";
    public static final String NORADIO_BUTTON_ID = "noRadio";
    public static final String FIRST_ALLERT_BUTTON_ID = "alertButton";
    public static final String SECOND_ALERT_BUTTON_ID = "timerAlertButton";
    public static final String THIRD_ALLERT_BUTTON_CSS = "#confirmButton";
    public static final String FOURTH_ALLERT_BUTTON_CSS = "#promtButton";
    public static final String IMAGE_BUTTON_CSS = "#a[href='https://demoqa.com']";
    public DemoQAPage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card")
    List<WebElement> cards;
    @FindBy(id = NEWTAB_BUTTON_ID)
    public WebElement newTabButton;
    @FindBy(id = YES_BUTTON_ID)
    public WebElement yesButton;
    @FindBy(id = NORADIO_BUTTON_ID)
    public WebElement noRadioButton;
    @FindBy(id = FIRST_ALLERT_BUTTON_ID)
    public WebElement firstButtonAlert;
    @FindBy(id = SECOND_ALERT_BUTTON_ID)
    public WebElement secondButtonAlert;
    @FindBy(css = THIRD_ALLERT_BUTTON_CSS)
    public WebElement thirdButtonAlert;
    @FindBy(css = FOURTH_ALLERT_BUTTON_CSS)
    public WebElement fourthButtonAlert;
    @FindBy(css = IMAGE_BUTTON_CSS)
    public WebElement image;

    public WebElement getNewTabButton() {
        return newTabButton;
    }
    public List<WebElement> getCards() {
        return cards;
    }
    public WebElement getYesButton() {
        return yesButton;
    }
    public WebElement getNoRadioButton() {
        return noRadioButton;
    }
    public WebElement getFirstButtonAlert() {
        return firstButtonAlert;
    }
    public WebElement getSecondButtonAlert() { return secondButtonAlert; }
    public WebElement getThirdButtonAlert() { return thirdButtonAlert; }
    public WebElement getFourthButtonAlert() { return fourthButtonAlert; }
    public WebElement getImage() { return image; }
}
