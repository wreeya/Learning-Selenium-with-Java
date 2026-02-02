package locatorsexample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SauceLoginByAbsoluteXPath {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        WebElement findUserNameField = driver.findElement(
                By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        WebElement findPasswordField = driver.findElement(
                By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(
                By.xpath("html/body/div/div/div[2]/div[1]/div/div/form/input"));

        findUserNameField.sendKeys("standard_user");
        findPasswordField.sendKeys("secret_sauce");
        loginButton.click();
    }
}
