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

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");

    }

    @Test

    public void fileUploadTest(){
        WebElement fileUpload  = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys("D:\\testfile.txt");

        WebElement fileSend = driver.findElement(By.id("file-submit"));
        fileSend.click();

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String text = uploadedFile.getText();
        assertEquals(text,"testfile.txt");

    }




    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
