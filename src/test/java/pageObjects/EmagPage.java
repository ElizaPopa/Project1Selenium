package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmagPage {
    public static final String CLOSE_BUTTON_CSS = "button.close";
    public static final String ACCEPT_BUTTON_CSS = "button.js-accept";
    public static final String LOGIN_BUTTON_CSS = "a.login-btn";
    public EmagPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ACCEPT_BUTTON_CSS)
    private WebElement acceptButton;
    @FindBy(css = LOGIN_BUTTON_CSS)
    private WebElement loginButton;
    @FindBy(css = CLOSE_BUTTON_CSS)
    private WebElement closeButton;
    public WebElement getAcceptButton() {
        return acceptButton;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }
}
