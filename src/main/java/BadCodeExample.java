import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BadCodeExample {
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
        System.out.println("Results  count: " + searchResults.size());
        if (searchResults.size()==10) {
            System.out.println("=10");
        }
        else {
            System.out.println("<10");
        }
        //verify  that each result item conteins searchterms*//
        int conteins=0;
        int notconteins=0;
        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            System.out.println(searchResultText);
            System.out.println("searchResultText");

            if (searchResultText.contains("selenium")) {
              conteins ++;
            }
             else {
                 notconteins ++;
            }
            //Use if/else operators to add simple verifications in Google search scenario
            //- Print message "Results count is correct" if there are 10 results and print "Results count is incorrect" if not 10.
            //- Print message "Searchterm found" if searchterm is present in result item and "Searchterm not found" if not.
        }
        System.out.println("SearchResult thet Conteins Term:" + conteins);
        System.out.println("SearchResult thet don't Conteins Term:" + notconteins);
        browser.close();
    }
}