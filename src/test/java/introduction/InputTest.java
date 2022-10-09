package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputTest {
    WebDriver driver;

    @BeforeMethod
    private void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=2000,3000");
        options.addArguments("--force-device-scale-factor=0.75");

        driver = new ChromeDriver(options);
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    @Test
    private void testInputFullName() {
        String expectedMassage = "Labas";
        String actualMassage;

        WebElement inputFullName =
                driver.findElement(By.xpath("//input[@id=\"user-message\"]"));
        inputFullName.sendKeys(expectedMassage);

        WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()='Show Message']"));
        buttonSubmit.click();
    }}