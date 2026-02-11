package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Datepicker {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        WebElement frameLocator = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frameLocator);

        WebElement calendar = driver.findElement(By.xpath("//input[@id='datepicker']"));
        calendar.click();

        String year = "2029";
        String month = "February";
        String day = "14";

        while (true) {
            WebElement monthField = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            String calendarMonth = monthField.getText();

            WebElement yearField = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String calendarYear = yearField.getText();

            if (calendarMonth.equals(month) && calendarYear.equals(year)) {
                break;
            } else {
                WebElement nextButton = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
                nextButton.click();
            }
        }

        List<WebElement> totalNumberOfDays = driver.findElements(
                By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td/a")
        );

        for (WebElement date : totalNumberOfDays) {
            String singleDay = date.getText();

            if (singleDay.equals(day)) {
                date.click();
                break;
            }
        }
    }
}
