package waitsinselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class OrangeHrmLogout {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated((By.name("username"))));
        WebElement passwordField = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("password")));
        WebElement loginButton = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.tagName("button")));
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        WebElement dropdown = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.className("oxd-userdropdown-tab")));

        dropdown.click();

        WebElement logout = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.linkText("Logout")));
        logout.click();
    }
}






