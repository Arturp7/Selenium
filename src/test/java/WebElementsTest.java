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

public class WebElementsTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Start");
        //sleep();
        String typeUserNameValue = userNameField.getAttribute("value");

        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @Test
    public void filePickingTest() {
        WebElement uploadFilePicker = driver.findElement(By.id("upload_file"));
        uploadFilePicker.sendKeys("D:\\cert_small.jpg");

    }

    @Test
    public void typingAndClearingValueInsideWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue, "Selenium Start");
        userNameField.clear();

        String emptyUserNameField = userNameField.getAttribute("value");

        assertEquals(emptyUserNameField, "");
    }

    @Test
    public void checkRadioButtonTest() {
        WebElement maleRadioButton = driver.findElement(By.cssSelector("input[value='male']"));
        WebElement femaleRadioButton = driver.findElement(By.cssSelector("input[value='female']"));

        maleRadioButton.click();
        assertTrue(maleRadioButton.isSelected());
        femaleRadioButton.click();
        assertTrue(femaleRadioButton.isSelected());
        assertFalse(maleRadioButton.isSelected());
    }

    @Test
    public void checkButtonTest() {
        WebElement pizzaCheckbox = driver.findElement(By.cssSelector("input[value='pizza']"));
        WebElement spaghettiCheckbox = driver.findElement(By.cssSelector("input[value='spaghetti']"));
        WebElement hamburgerCheckbox = driver.findElement(By.cssSelector("input[value='hamburger']"));

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertTrue(pizzaCheckbox.isSelected());
        assertTrue(spaghettiCheckbox.isSelected());
        assertTrue(hamburgerCheckbox.isSelected());

        pizzaCheckbox.click();
        spaghettiCheckbox.click();
        hamburgerCheckbox.click();

        assertFalse(pizzaCheckbox.isSelected());
        assertFalse(spaghettiCheckbox.isSelected());
        assertFalse(hamburgerCheckbox.isSelected());
    }

    @Test
    public void dropDownListTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));

        Select countryDropdown = new Select(countryWebElement);

        List<WebElement> options = countryDropdown.getOptions();

        List<String> namesOfOptions = new ArrayList<String>();

        for (WebElement option : options) {
            namesOfOptions.add(option.getText());
            System.out.println(option.getText());
        }
        List<String> expectedNamesOfOptions = new ArrayList<String>();
        expectedNamesOfOptions.add("Germany");
        expectedNamesOfOptions.add("Poland");
        expectedNamesOfOptions.add("UK");

        assertEquals(namesOfOptions, expectedNamesOfOptions);
    }

    @Test
    public void selectingOptionsFromDropDownTest() {
        WebElement countryWebElement = driver.findElement(By.id("country"));
        Select countryDropDown = new Select(countryWebElement);

        countryDropDown.selectByIndex(1);

        //   sleep();

        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Poland");

        countryDropDown.selectByValue("de_DE");
        //   sleep();
        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "Germany");

        countryDropDown.selectByVisibleText("UK");

        assertEquals(countryDropDown.getFirstSelectedOption().getText(), "UK");
    }

    @Test
    public void checkElementsOnPageTest() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement emailLabel = driver.findElement(By.cssSelector("span[class='help-block']"));

        System.out.println("Is usernameField displayed:" + usernameField.isDisplayed());
        System.out.println("Is usernameField enabled" + usernameField.isEnabled());

        System.out.println("Is passwordField displayed:" + passwordField.isDisplayed());
        System.out.println("Is passwordField enabled:" + passwordField.isEnabled());

        System.out.println("Is emailLabel displayed" + emailLabel.isDisplayed());
        System.out.println("Is emailLabel enabled" + emailLabel.isEnabled());

        assertTrue(usernameField.isDisplayed());
        assertTrue(passwordField.isDisplayed());
        assertTrue(emailLabel.isDisplayed());

        assertTrue(usernameField.isEnabled());
        assertTrue(passwordField.isEnabled());


    }


    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
