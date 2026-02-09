package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice-automation.com/form-fields/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement nameField = driver.findElement(By.id("name-input"));
        nameField.sendKeys("Riya");

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Riya@123");

        WebElement password = driver.findElement(
                By.xpath("//input[@type='password']")
        );

        jse.executeScript("arguments[0].scrollIntoView({block:'center'});", password);
        List<WebElement> drinkLabels = driver.findElements(
                By.xpath("//label")
        );

        for (WebElement drink : drinkLabels) {
            String drinkValue = drink.getText();

            if (drinkValue.equals("Water")) {
                drink.click();
            }

            if (drinkValue.equals("Milk")) {
                drink.click();
            }

            if (drinkValue.equals("Coffee")) {
                drink.click();
            }
        }
        WebElement favColorLabel = driver.findElement(
                By.xpath("//label[text()='What is your favorite color?']")
        );

        jse.executeScript("arguments[0].scrollIntoView(true);", favColorLabel);


        WebElement favcolor = driver.findElement(By.id("color2"));
        favcolor.click();


        WebElement Email = driver.findElement(
                By.xpath("//label[text()='Email']")
        );

        jse.executeScript("arguments[0].scrollIntoView(true);", Email);

        WebElement EmailField = driver.findElement(By.id("email"));
        EmailField.sendKeys("Riya123@gmail.com");

        WebElement messageBox = driver.findElement(By.id("message"));
        messageBox.sendKeys("Hello");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitBtn = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("submit-btn"))
        );

        jse.executeScript("arguments[0].click();", submitBtn);


    }
}

