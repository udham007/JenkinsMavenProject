/*package com.renju.training.jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	@Test
	public void validateGoogleId() throws Exception {
		System.out.println("Opening Browser");
		driver.get("http://www.google.com");
		System.out.println("Clicking Gmail Link");
		driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).click();
		System.out.println("Clicking Sign In link");
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		System.out.println("Entering username");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("renju.jenkins.training");
		System.out.println("Clicking Next button");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		Thread.sleep(5000);
		boolean textFound = driver.getPageSource().contains("Forgot password");
		AssertJUnit.assertTrue(textFound);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
*/
package com.renju.training.jenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleSeleniumTest {

     boolean flag = true;
    public WebDriver driver;
    public String baseurl = "http://google.com";



    @BeforeTest
     public void launchbrowser()

    {
        System.out.println("LaunchBrowser called...");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseurl);
    }


    @BeforeMethod
    public void Beforemethod() {
        System.out.println("Hello Before Method");
    }

    @Test(priority = 0)
    public void GmailTap() {
        System.out.println("Test priority 0 called...");
        driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).click();
        System.out.println("hello");
        driver.findElement(By.id("Email")).sendKeys("virendra.cbo@gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.HOURS);
        driver.findElement(By.name("signIn")).click();
        boolean flag = true;
        while (flag) {
            try {
                driver.findElement(By.name("Passwd")).sendKeys("Qwerty@123");
                System.out.println("Executed");
                flag = false;
            } catch (Exception e) {
            }
        }

        driver.findElement(By.id("signIn")).click();
        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();

    }





    @Test(priority = 1)
    public void GmailTap2() {
        System.out.println("Test priority 1 called...");
        System.out.println("hello");
        driver.findElement(By.id("Email")).sendKeys("virendra.cbo@gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.HOURS);
        driver.findElement(By.name("signIn")).click();
        boolean flag = true;
        while (flag) {
            try {
                driver.findElement(By.name("Passwd")).sendKeys("Qwerty@123");
                System.out.println("Executed");
                flag = false;
            } catch (Exception e) {
            }
        }

        driver.findElement(By.id("signIn")).click();

        driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();

    }


    @AfterMethod
    public void aftersignout1() {

        if (flag)
         {
            driver.findElement(By.xpath("//*[@id=\"account-chooser-link\"]")).click();
         flag = false;
         }
        driver.findElement(By.xpath("//*[@id=\"account-chooser-add-account\"]")).click();
    }
    //*[@id="account-chooser-add-account"]
    @AfterTest
    public void aftersignout() {
        System.out.println("aftersignOut called...");
        // New Accnt`enter code here`
        driver.close();
    }
    }
