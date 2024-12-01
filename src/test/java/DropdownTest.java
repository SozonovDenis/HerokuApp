import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


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
    public void CheckAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Находим все значения выпадашки в т.ч. значение-плейсхолдер
        WebElement v0 = driver.findElement(By.xpath("//option[1]"));
        WebElement v1 = driver.findElement(By.xpath("//option[@value='1']"));
        WebElement v2 =  driver.findElement(By.xpath("//option[@value='2']"));

        //Проверяем отображение всех значений
        Assert.assertTrue(v0.isDisplayed());
        Assert.assertTrue(v1.isDisplayed());
        Assert.assertTrue(v2.isDisplayed());

        //Проверяем что выбрано значение-плейсхолдер
        Assert.assertTrue(v0.isSelected());

        //Выбираем первое значение, проверяем что оно выбрано
        v1.click();
        Assert.assertTrue(v1.isSelected());

        //Выбираем второе значение, проверяем что оно выбрано
        v2.click();
        Assert.assertTrue(v2.isSelected());

    }

    @AfterTest
    public void tearDown() {
      //  driver.quit();
    }


}
