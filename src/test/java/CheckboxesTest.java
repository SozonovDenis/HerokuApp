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



public class CheckboxesTest {
    WebDriver driver;


    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //Поиск чб-шек
        WebElement cb1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
        WebElement cb2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));

        //Проверка 1 чб
        Assert.assertFalse(cb1.isSelected());
        cb1.click();
        Assert.assertTrue(cb1.isSelected());

        //Проверка 2 чб
        Assert.assertTrue(cb2.isSelected());
        cb2.click();
        Assert.assertFalse(cb2.isSelected());
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }





}
