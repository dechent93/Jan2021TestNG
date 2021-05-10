package variousConcepts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest_TestNG {

	WebDriver driver;
	
	
	@BeforeMethod
	public void launchBrowser() {
	
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();

	driver.get("https://techfios.com/billing/?ng=admin/");			
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test
	public void loginTest() {
		
	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "Wrong Page!!");
		
	WebElement USER_NAME_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
	WebElement PASSWORD_FIELD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
	WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
	
	USER_NAME_FIELD_ELEMENT.sendKeys("demo@techfios.com");
	PASSWORD_FIELD_ELEMENT.sendKeys("abc123");
	SIGNIN_BUTTON_ELEMENT.click();
	
	Assert.assertEquals(driver.getTitle(), "Dashboard- iBilling", "Wrong Page!!");
	
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.close();
	
	}
}