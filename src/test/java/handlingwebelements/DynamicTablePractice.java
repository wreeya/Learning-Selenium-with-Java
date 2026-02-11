package handlingwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;

public class DynamicTablePractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement dynamicTableText = driver.findElement(
                By.xpath("//h2[text()='Dynamic Web Table']")
        );

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", dynamicTableText);

        List<WebElement> numberOfRows = driver.findElements(
                By.xpath("//table[@id='taskTable']/tbody/tr")
        );

        String chromeCPU = "";
        String firefoxMemory = "";
        String chromeNetwork = "";
        String firefoxDisk = "";

        for (int row = 1; row <= numberOfRows.size(); row++) {

            WebElement nameColumn = driver.findElement(
                    By.xpath("//table[@id='taskTable']/tbody/tr[" + row + "]/td[1]")
            );

            String browserName = nameColumn.getText();

            if (browserName.equals("Chrome")) {
                chromeCPU = driver.findElement(
                        By.xpath("//table[@id='taskTable']/tbody/tr[" + row + "]/td[4]")
                ).getText();

                chromeNetwork = driver.findElement(
                        By.xpath("//table[@id='taskTable']/tbody/tr[" + row + "]/td[3]")
                ).getText();
            }

            if (browserName.equals("Firefox")) {
                firefoxMemory = driver.findElement(
                        By.xpath("//table[@id='taskTable']/tbody/tr[" + row + "]/td[2]")
                ).getText();

                firefoxDisk = driver.findElement(
                        By.xpath("//table[@id='taskTable']/tbody/tr[" + row + "]/td[5]")
                ).getText();
            }
        }

        String cpuLabel = driver.findElement(
                By.xpath("//p[contains(text(),'CPU load of Chrome process')]")
        ).getText();

        String memoryLabel = driver.findElement(
                By.xpath("//p[contains(text(),'Memory Size of Firefox process')]")
        ).getText();

        String networkLabel = driver.findElement(
                By.xpath("//p[contains(text(),'Network speed of Chrome process')]")
        ).getText();

        String diskLabel = driver.findElement(
                By.xpath("//p[contains(text(),'Disk space of Firefox process')]")
        ).getText();

        if (cpuLabel.contains(chromeCPU)) {
            System.out.println("CPU matched: " + chromeCPU);
        } else {
            System.out.println("CPU NOT matched");
        }

        if (memoryLabel.contains(firefoxMemory)) {
            System.out.println("Memory matched: " + firefoxMemory);
        } else {
            System.out.println("Memory NOT matched");
        }

        if (networkLabel.contains(chromeNetwork)) {
            System.out.println("Network matched: " + chromeNetwork);
        } else {
            System.out.println("Network NOT matched");
        }

        if (diskLabel.contains(firefoxDisk)) {
            System.out.println("Disk matched: " + firefoxDisk);
        } else {
            System.out.println("Disk NOT matched");
        }


    }
}
