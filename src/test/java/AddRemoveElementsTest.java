import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class AddRemoveElementsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Добавить две кнопки
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        //Нажать кнопку
        driver.findElement(By.xpath("//button[text()='Delete']")).click();

        //Подсчет и сравнение кол-ва элементов с ожидаемым
        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        int expectedCount = 1; // Ожидаемое количество элементов
        Assert.assertEquals(elements.size(), expectedCount);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
