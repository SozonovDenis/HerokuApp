import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class CheckboxesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Checkboxes() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        SoftAssert softAssert = new SoftAssert();

        //Поиск чб-шек
        WebElement cb1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement cb2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        //Проверка 1 чб
        softAssert.assertFalse(cb1.isSelected(), "cb1 is selected");
        cb1.click();
        softAssert.assertTrue(cb1.isSelected(), "cb1 is not selected");

        //Проверка 2 чб
        softAssert.assertTrue(cb2.isSelected(), "cb2 is not selected");
        cb2.click();
        softAssert.assertFalse(cb2.isSelected(), "cb2 is selected");

        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
