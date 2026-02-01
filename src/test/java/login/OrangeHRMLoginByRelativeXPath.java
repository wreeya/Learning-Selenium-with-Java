package login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OrangeHRMLoginByRelativeXPath {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(
                By.xpath("//input[@name='username']")
        ).sendKeys("Admin");

        driver.findElement(
                By.xpath("//input[@name='password']")
        ).sendKeys("admin123");

        driver.findElement(
                By.xpath("//button[@type='submit']")
        ).click();
    }
}
