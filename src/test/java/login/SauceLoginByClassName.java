package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceLoginByClassName {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        WebElement userNameField = driver.findElement(
                By.cssSelector("input.input_error.form_input")
        );

        WebElement passwordField = driver.findElement(
                By.cssSelector("input[type='password']")
        );

        WebElement loginButton = driver.findElement(
                By.cssSelector("input.submit-button.btn_action")
        );

        userNameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();
    }
}
