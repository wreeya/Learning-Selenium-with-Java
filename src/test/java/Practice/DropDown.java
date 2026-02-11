package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class DropDown {
    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/calendars/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        WebElement dateInput = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("input.jp-contact-form-date"))
        );
        dateInput.click();


        while (true) {
            WebElement monthBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.dp-cal-month"))
            );
            WebElement yearBtn = driver.findElement(By.cssSelector("button.dp-cal-year"));

            String month = monthBtn.getText();
            String year = yearBtn.getText();

            if (month.equals("December") && year.equals("2030")) {
                break;
            } else {
                driver.findElement(By.cssSelector("button.dp-next")).click();
            }
        }


        List<WebElement> days = driver.findElements(By.cssSelector("button.dp-day"));

        for (WebElement day : days) {
            if (day.getText().equals("31")) {
                day.click();
                break;
            }
        }


    }
}
