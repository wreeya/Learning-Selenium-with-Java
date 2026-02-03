package locatorsexample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class CountLinksIMDB {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.imdb.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        driver.quit();
    }
}
