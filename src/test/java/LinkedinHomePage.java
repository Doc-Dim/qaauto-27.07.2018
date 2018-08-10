import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinHomePage {

    private WebDriver browser;
    private WebElement profileNavigationItem;


    public LinkedinHomePage(WebDriver browser) {
        this.browser = browser;
        initElements();
    }
    private void initElements(){
        profileNavigationItem = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));

    }


    public String getCurrentPageTitle (){
        return browser.getTitle();
    }
    public String getCurrentPageUrl(){
        return browser.getCurrentUrl();
    }

    public boolean isLoaded() {
        return profileNavigationItem.isDisplayed() &&
                getCurrentPageTitle().contains("Linkedin")
                && getCurrentPageUrl().contains("/feed/");

    }
}


/*Home Task #4:
Update successfulLoginTest() to use LinkedinHomePage object.
- Create new page object class called LinkedinHomePage.class
- Move profileNavidationItem into this new class
- Add LinkedinHomePage constructor with browser parameter
- Add initElements() method to initialise profoleNavigationItem
- Add boolean method isProfileNavigationItemDisplayed() in a new class.
- Use new LinkedinHomePage in successfulLoginTest()
- Use isProfileNavigationItemDisplayed() method in last Assert.*/