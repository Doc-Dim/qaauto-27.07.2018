import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    public void successFullLoginTest()  {

       linkedinLoginPage.login("m.dimchik.test@gmail.com", "welcome123");

         LinkedinHomePage linkedinHomePage = new LinkedinHomePage(browser);
         Assert.assertTrue(linkedinHomePage.isLoaded(), "Home page is not loaded");

    }

    @Test
    public void negativeLoginTest() {

        linkedinLoginPage.login("m.dmck@l.com", "wele123");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);


        assertEquals(linkedinLoginSubmitPage.getAlertBoxText(),
                "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");


    }

    @DataProvider
    public Object[][] emptyFieldsCombination() {
        return new Object[][]{
                { "", "" },
                { "", "Password123" },
                { "someone@domail.com", "" },
        };
    }
    @Test(dataProvider = "emptyFieldsCombination")
        public void validateEmptyUserEmailAndUserPassword (String userEmail, String userPass){
        linkedinLoginPage.login(userEmail, userPass);
        Assert.assertTrue(linkedinLoginPage.isLoaded(), "User is not on login page");
        }







    @Test
    public  void  validateShortUserEmailAndPassword(){
        linkedinLoginPage.login("a","a");
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(browser);
        Assert.assertTrue(linkedinLoginSubmitPage.isLoaded(), "User is not on LoginSubmit page");

        Assert.assertEquals(linkedinLoginSubmitPage.getAlertBoxText(), "При заполнении формы были допущены ошибки. Проверьте и исправьте отмеченные поля.",
                "Alert box has incorrect message");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserEmailValidationText(), "The text you provided is too short (the minimum length is 3 characters, your text contains 1 character.",
                "userEmail field has wrong validation message text");

        Assert.assertEquals(linkedinLoginSubmitPage.getUserPasswordValidationText(), "The password you provided must have at least 6 characters.", "userEmail field has wrong validation message text");

    }




}







