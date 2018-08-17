import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinLoginPage extends BasePage{



    @FindBy(xpath = "//*[@id=\"login-email\"]")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id=\"login-password\"]")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id=\"login-submit\"]")
    private WebElement signInButton;


    public LinkedinLoginPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }


    public LinkedinLoginPage loginReturnLoginPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginPage (browser);
    }

    public LinkedinHomePage loginReturnHomePage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinHomePage (browser);
    }
    public LinkedinLoginSubmitPage loginReturnLoginSubmitPage(String userEmail, String userPass) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPass);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinLoginSubmitPage (browser);
    }


    public boolean isLoaded() {
        return userEmailField.isDisplayed() &&
                getCurrentPageTitle().contains("LinkedIn: Log In or Sign Up");

    }
}
