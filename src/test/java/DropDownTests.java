import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class DropDownTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
   public void dropDownTest() {

        WebElement listWebElement = driver.findElement(By.id("dropdown"));
        Select listDropDown = new Select(listWebElement);

        String selectedOption = listDropDown.getFirstSelectedOption().getText();
        assertEquals(selectedOption,"Please select an option");

        listDropDown.selectByValue("1");
        selectedOption = listDropDown.getFirstSelectedOption().getText();

        assertEquals(selectedOption,"Option 1");

        listDropDown.selectByValue("2");
        selectedOption = listDropDown.getFirstSelectedOption().getText();

        assertEquals(selectedOption,"Option 2");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}
