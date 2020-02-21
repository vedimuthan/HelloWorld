package test.java.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class containerTest {

	 //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;

    //Declare a test URL variable
    public String testURL = "https://www.swtestacademy.com/";

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest (){
        //Create a new ChromeDriver
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--no-sandbox");
  		options.addArguments("--single-process");
  		options.addArguments("--start-maximized");         // open Browser in maximized mode
  		options.addArguments("--disable-infobars");        // disabling infobars
      options.addArguments("--headless");
      options.addArguments("--disable-gpu");
      options.addArguments("'window-size=1024,768'");
      options.addArguments("--disable-features=VizDisplayCompositor");
      options.addArguments("--incognito");
      options.addArguments("enable-automation");
      options.addArguments("--disable-extensions");
      options.addArguments("--dns-prefetch-disable");
      options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      options.setExperimentalOption("useAutomationExtension", false);

    	//options.setExperimentalOption(useAutomationExtension, false);
        driver = new ChromeDriver(options);
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        //Go to www.swtestacademy.com
        driver.navigate().to(testURL);
    }

    //-----------------------------------Tests-----------------------------------
    @Test
    public void firstTest () {
        //Get page title
        String title = driver.getTitle();

        //Print page's title
        System.out.println("Page Title: " + title);

        //Assertion
        Assert.assertEquals(title, "Software Test Academy", "Title assertion is failed!");
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest (){
        //Close browser and end the session
        driver.quit();
    }

}
