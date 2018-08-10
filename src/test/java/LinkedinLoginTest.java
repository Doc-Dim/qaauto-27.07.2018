import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class LinkedinLoginTest {
    /*preconditions*/
    WebDriver browser;
    /*связать две переменние*/
  @BeforeMethod
   public void beforeMethod() {
      browser = new FirefoxDriver();
      browser.get("https://www.linkedin.com/");
  }
  /*close browser*/
    @AfterMethod
    public void afterMethod(){
        browser.close();
        /*выплняется после метода*/
    }
    public void  LinkedinHomePage(){

    }


    @Test
    public void successfulllogintest() throws InterruptedException {

       LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(browser);
       linkedinLoginPage.login("m.dimchik.test@gmail.com", "welcome123");

        sleep(3000);


        //*Assert page Title after login
        String pageTitle = browser.getTitle();
        Assert.assertEquals(pageTitle, "LinkedIn", "Home page Title is wrong");
        /*сравневает два обьекта*/

        //*Assert some specific WebElement is displayed after login
         WebElement profileNavigationItem = browser.findElement(By.xpath("//*[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavigationItem.isDisplayed(),"'profileNavigationItem' is not displayed on Home page");



        //*Assert page URL after login
        String pageUrl = browser.getCurrentUrl();
        Assert.assertEquals(pageUrl, "https://www.linkedin.com/feed/","Home page url is wrong");

    }




    @Test
    public void negativelogintest() throws InterruptedException {

        WebElement userEmailField = browser.findElement(By.xpath("//*[@id=\"login-email\"]"));
        WebElement userPasswordField = browser.findElement(By.xpath("//*[@id=\"login-password\"]"));
        WebElement signInButton = browser.findElement(By.xpath("//*[@id=\"login-submit\"]"));
        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("wrong");
        signInButton.click();
        sleep(4000);
        WebElement alertBox = browser.findElement(By.xpath("//*[@role='alert']"));

        assertEquals(alertBox.getText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");
    }


}

