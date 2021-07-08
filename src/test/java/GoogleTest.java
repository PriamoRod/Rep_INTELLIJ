import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class GoogleTest {



    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
    }

    @Test
    public void testGoogle(){

        WebElement searchbox = driver.findElement(By.name("q"));

        searchbox.clear();
        searchbox.sendKeys("selenium");
        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("selenium",driver.getTitle());

    }

    @After
    public void tearDown(){
        driver.quit();
    }


    public void main (String [] args){

        setUp();
        tearDown();



    }


    }





















/*ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized");

       ChromeDriver driver = new ChromeDriver(options

       );*/