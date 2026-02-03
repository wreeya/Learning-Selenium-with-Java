package waitsinselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class OrangeHrmFluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        WebElement usernameField = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("username")));
        WebElement passwordField = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("password")));
        WebElement loginButton = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.tagName("button")));
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
    }
}
