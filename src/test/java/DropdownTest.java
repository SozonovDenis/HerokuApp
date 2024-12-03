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

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        SoftAssert softAssert = new SoftAssert();

        //Находим все значения выпадашки в т.ч. значение-плейсхолдер
        WebElement v0 = driver.findElement(By.xpath("//option[1]"));
        WebElement v1 = driver.findElement(By.xpath("//option[@value='1']"));
        WebElement v2 = driver.findElement(By.xpath("//option[@value='2']"));

        //Проверяем отображение всех значений
        softAssert.assertTrue(v0.isDisplayed(), "Placeholder value is not displayed");
        softAssert.assertTrue(v1.isDisplayed(), "1st value is not displayed");
        softAssert.assertTrue(v2.isDisplayed(), "2nd value is not displayed");

        //Проверяем что выбрано значение-плейсхолдер
        softAssert.assertTrue(v0.isSelected(), "Placeholder value is not selected");

        //Выбираем первое значение, проверяем что оно выбрано
        v1.click();
        softAssert.assertTrue(v1.isSelected(), "1st value is not selected");

        //Выбираем второе значение, проверяем что оно выбрано
        v2.click();
        softAssert.assertTrue(v2.isSelected(), "2nd value is not selected");

        softAssert.assertAll();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
