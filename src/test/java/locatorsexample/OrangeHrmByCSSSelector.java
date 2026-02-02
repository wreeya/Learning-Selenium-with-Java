package locatorsexample;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmByCSSSelector {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement userNameField = driver.findElement(
                By.cssSelector("input[placeholder='Username']"));
        WebElement passwordField = driver.findElement(
                By.cssSelector("input[name='password']"));
        WebElement loginButton = driver.findElement(
                By.cssSelector("button[type='submit']"));

        userNameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();
    }
}
