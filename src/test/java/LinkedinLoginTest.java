import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LinkedinLoginTest {
    /*preconditions*/
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;
    /*связать две переменние*/
  @BeforeMethod
   public void beforeMethod() {
      browser = new FirefoxDriver();
      browser.get("https://www.linkedin.com/");
      linkedinLoginPage = new LinkedinLoginPage(browser);
  }
  /*close browser*/
    @AfterMethod
    public void afterMethod(){
        browser.close();
        /*выплняется после метода*/
    }


    @Test
    public void successfulllogintest()  {

       linkedinLoginPage.login("m.dimchik.test@gmail.com", "welcome123");

         LinkedinHomePage linkedinHomePage = new LinkedinHomePage(browser);
         Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded");

    }



    @Test
    public void negativelogintest()  {

        linkedinLoginPage.login("m.dmchik@l.com", "wele123");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);

        assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");
    }







}

