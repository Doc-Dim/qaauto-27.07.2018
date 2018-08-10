import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LinkedinHomePage {

    WebDriver browser;

    public LinkedinHomePage () {

    this.browser = browser;
    initElements();
}


    public void initElements(){
    WebElement profileNavigationItem = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));
    Assert.assertTrue(profileNavigationItem.isDisplayed(),"'profileNavigationItem' is not displayed on Home page");

    }

    public boolean ProfileNavigationItemPresent(){
        profileNavigationItem() = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));
        return profileNavigationItem.isDisplayed();
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