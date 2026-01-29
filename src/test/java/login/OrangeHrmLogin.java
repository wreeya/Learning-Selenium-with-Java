package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmLogin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        WebElement username = driver.findElement(
                By.name("username")
        );


        WebElement password = driver.findElement(
                By.name("password")
        );


        WebElement loginButton = driver.findElement(
                By.cssSelector("button[type='submit']")
        );


        username.sendKeys("Admin");
        password.sendKeys("admin123");


        loginButton.click();
    }
}

