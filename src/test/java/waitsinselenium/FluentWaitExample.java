package waitsinselenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class FluentWaitExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");


        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);


        WebElement usernameField = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        WebElement passwordField = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("password")));

        WebElement loginButton = fluentWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("login-button")));


        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }
}

