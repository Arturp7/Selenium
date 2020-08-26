import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class CheckBoxesTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");
    }



    @Test
    public void checkboxesTest(){

        WebElement checkBox1 = driver.findElement(By.xpath("//body//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//body//input[2]"));

        Assert.assertFalse(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

        checkBox1.click();
        checkBox2.click();

        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertFalse(checkBox2.isSelected());


    }



    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }




}
