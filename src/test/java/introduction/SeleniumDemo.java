package introduction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class SeleniumDemo {

    WebDriver driver;

    @BeforeMethod
    private void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDemoWebDriver(){
        driver.get("https://www.vilniuscoding.lt/");
        try {
            driver.manage().window().fullscreen();
            Thread.sleep(3000);

            driver.manage().window().maximize();
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClickKontaktaiOfVcsWebPage(){
        driver.get("https://www.vilniuscoding.lt/");

        WebElement linkKontaktai = driver.findElement(By.id("menu-item-3969"));
        linkKontaktai.click();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testClickKontaktaiOfVcsWebPageWithSmallWindow(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=600,3000");
        options.addArguments("--start-in-incognito");

        driver = new ChromeDriver(options);
        driver.get("https://www.vilniuscoding.lt/");

        try {
            WebElement buttonBurger = driver.findElement(By.id("burger"));
            buttonBurger.click();

            Thread.sleep(2000);

            WebElement linkKontaktai = driver.findElement(By.id("menu-item-3969"));
            linkKontaktai.click();

            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    @AfterMethod
    private void close(){
        driver.quit();
    }
}
