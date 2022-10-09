package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSelenium {

    WebDriver driver;

    @BeforeMethod
    private void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=2000,3000");
        options.addArguments("--force-device-scale-factor=0.75");
//        options.addArguments("headless");

        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    private void testInputFullName() {
        String expectedFullName = "Elina Cerniavskaja";
        String actualFullName;

        WebElement inputFullName =
                driver.findElement(By.xpath("//input[@id='userName']"));
        inputFullName.sendKeys(expectedFullName);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textName = driver.findElement(By.xpath("//*[@id='name']"));
        actualFullName = textName.getText();


        Assert.assertTrue(
                actualFullName.contains(expectedFullName),
                String.format(
                        "Actual [%s]; Expected [%s]",
                        actualFullName,
                        expectedFullName
                )
        );
    }

    @Test
    private void testInputEmail() {
        String expectedUserEmail = "elina.cerniavskaja@gmail.com";
        String actualUserEmail;

        WebElement inputUserEmail =
                driver.findElement(By.xpath("//*[@id='userEmail']"));
        inputUserEmail.sendKeys(expectedUserEmail);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textUserEmail = driver.findElement(By.xpath("//*[@id='email']"));
        actualUserEmail = textUserEmail.getText();

        Assert.assertTrue(
                actualUserEmail.contains(expectedUserEmail),
                String.format(
                        "Actual [%s]; Expected [%s]",
                        actualUserEmail,
                        expectedUserEmail
                )
        );
    }

    @Test
    private void testInputCurrentAddress() {
        String expectedCurrentAddress = "Simono Grunau 123-6";
        String actualCurrentAddress;

        WebElement inputCurrentAddress =
                driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        inputCurrentAddress.sendKeys(expectedCurrentAddress);

        WebElement buttonSubmit = driver.findElement(By.xpath("//*[@id='submit']"));
        buttonSubmit.click();

        WebElement textName = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        actualCurrentAddress = textName.getText();

        Assert.assertTrue(
                actualCurrentAddress.contains(expectedCurrentAddress),
                String.format(
                        "Actual [%s]; Expected [%s]",
                        actualCurrentAddress,
                        expectedCurrentAddress
                )
        );
    }


    @AfterMethod
    private void close() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
