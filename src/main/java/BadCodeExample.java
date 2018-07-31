import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BadCodeExample{
    public static void main(String args[]) throws InterruptedException {
     System.out.println("Hello Doc_Dim!!!");
     WebDriver browser = new FirefoxDriver();
     browser.get("Https://www.google.com/");
     WebElement queryField = browser.findElement(By.name("q"));
     queryField.sendKeys("selenium");
     queryField.sendKeys(Keys.ENTER);
     Thread.sleep(4000);
     //*verify that results list contains 10 elements*//
        List<WebElement> searchResults = browser.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println("Results  count: " +searchResults.size());
        //verify  that each result item conteins searchterms*//
        for (WebElement searchResult: searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
        }
                             //HOME task search result count is 10 result - count resalt is wrong and 10 is ok и то что в каждом результате есть слово селениум - одна проверка пред фор а вторая внутри//





     browser.close();
    }
}