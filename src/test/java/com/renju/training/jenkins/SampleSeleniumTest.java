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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
    public WebDriver driver;
    public String baseurl = "http://google.com";

    @BeforeMethod
    public void launchbrowser()

    {
        System.out.println("LaunchBrowser called...");
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseurl);
    }

    @Test(priority = 0)
    public void GmailTap() {
        System.out.println("Test priority 0 called...");
        driver.findElement(By.linkText("Gmail")).click();

        System.out.println("hello");
        driver.findElement(By.id("Email")).sendKeys("virendra.cbo@gmail.com");
        driver.findElement(By.id("next")).click();

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
        System.out.println("Test priority 0 called...");
        driver.findElement(By.linkText("Gmail")).click();

        System.out.println("hello");
        driver.findElement(By.id("Email")).sendKeys("virendra.cbo@gmail.com");
        driver.findElement(By.id("next")).click();

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

        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")));
        myDynamicElement.click(); // driver.findElement(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
                                    // driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();

    }

    // ____________

    @AfterMethod
    public void aftersignout() {
        System.out.println("aftersignOut called..."); // New Accnt

        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account-chooser-link\"]")));
        myDynamicElement.click();

        driver.findElement(By.xpath("//*[@id=\"account-chooser-add-account\"]")).click();
        driver.quit();
    } // *[@id="account-chooser-add-account"]

}
