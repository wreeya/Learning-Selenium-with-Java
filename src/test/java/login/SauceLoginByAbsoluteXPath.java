package login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SauceLoginByAbsoluteXPath {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");


        driver.findElement(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input")
        ).sendKeys("standard_user");


        driver.findElement(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input")
        ).sendKeys("secret_sauce");


        driver.findElement(
                By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input")
        ).click();
    }
}
