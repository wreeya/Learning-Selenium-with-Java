package handlingwebelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.List;

public class StaticTablePractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice-automation.com/tables/");

        List<WebElement> tableContent = driver.findElements(
                By.xpath("//figure[@class='wp-block-table']/table/tbody/tr/td")
        );

        for (WebElement tableData : tableContent) {
            String tablePrint = tableData.getText();
            System.out.println(tablePrint);
        }

        List<WebElement> tableRowCount = driver.findElements(
                By.xpath("//figure[@class='wp-block-table']/table/tbody/tr")
        );
        System.out.println("The total number of rows is: " + tableRowCount.size());

        List<WebElement> tableColumnCount = driver.findElements(
                By.xpath("//figure[@class='wp-block-table']/table/tbody/tr/td/strong")
        );
        System.out.println("The total number of column is: " + tableColumnCount.size());
    }
}

