package variousConcepts;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LearnTestNG {
	WebDriver driver;
//	String browser = "null";
//	String url;

	@BeforeMethod
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		driver = new ChromeDriver();

		driver.get("https://techfios.com/billing/?ng=admin/");			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Properties prop = new Properties();
//		try {
//			InputStream input = new InputStream("./src/main/java/cpnfig/config.properties");
//			prop.load(input);
//			browser = prop.getProperty("browser");
//			System.out.println("Browser used: " + browser);
//			url = prop.getProperty("url");
//		}
//		catch(IOException e) {
//			
//			e.printStackTrace();
//		}
//		if(browser == "chrome") {
//			System.setProperty("webdriver.chrome.driver", "chromedriver");
//			driver = new ChromeDriver();
//		}else if (browser.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.gecko.driver", "geckodriver");
//		}
//	}
		
//		System.setProperty("webdriver.gecko.driver","geckodriver");
//		driver = new FirefoxDriver();
//		driver.get("https://techfios.com/billing/?ng=admin/");
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		System.setProperty("webdriver.chrome.driver","chromedriver");
//		driver = new ChromeDriver();
//
//		driver.get("https://yahoo.com/");			
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//	@Test (priority = 1)
//	public void loginTest () throws InterruptedException {
//		
//	Assert.assertEquals(driver.getTitle(), "Login - iBilling", "Wrong page");
//
//	
//	WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
//	WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
//	WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
//	
//	String loginId = "demo@techfios.com";
//	String password = "abc123";
//	
//	USER_NAME_ELEMENT.sendKeys(loginId);
//	PASSWORD_ELEMENT.sendKeys(password);
//	SIGNIN_BUTTON_ELEMENT.click();
//	
//	WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(). 'Dashboard')]"));
//	
//	Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong page");
//	}
	
	@Test //(priority = 2)
	public void addCustomer() {
		
		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name='login']"));
		
		//login data
		String loginId = "demo@techfios.com";
		String password = "abc123";
		
		// Test data
		String fullName = "Test Jan";
		String companyName = "Google";
		String email = "techfios@gmail.com";
		String phone = "24152618819";
		
		USER_NAME_ELEMENT.sendKeys(loginId);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
		
		WebElement DASHBOARD_TITLE_ELEMENT = driver.findElement(By.xpath("//h2[contains(text(). 'Dashboard')]"));
		Assert.assertEquals(DASHBOARD_TITLE_ELEMENT.getText(), "Dashboard", "Wrong page");
		
		WebElement CUSTOMER_ELEMENT = driver.findElement(By.xpath("//*@id-\"side-menu\"]/li[3]/a/span[1]"));
		WebElement ADD_CUSTOMER_ELEMENT = driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a"));
		

		CUSTOMER_ELEMENT.click();
		ADD_CUSTOMER_ELEMENT.click();
		
		WebElement FULL_NAME_ELEMENT = driver.findElement(By.xpath("//*[@id=\"account\"]"));
		WebElement COMPANY_DROPDOWN_ELEMENT = driver.findElement(By.xpath("//select[@id='cid']"));
		WebElement EMAIL_ELEMENT = driver.findElement(By.xpath("//*[@id\"email\"]"));
		
		
		
		FULL_NAME_ELEMENT.sendKeys(fullName);
		
		//dropdown
		Select sel = new Select( COMPANY_DROPDOWN_ELEMENT);
		sel.selectByVisibleText(companyName);
		
		
		//Generate Random Number
		Random rnd = new Random();
		int randomNum = rnd.nextInt(999);
		
		//Fill Email
		EMAIL_ELEMENT.sendKeys(randomNum + email);
		
		}
	public void waitForElement(WebDriver driver, int waitTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@AfterMethod
	public void tearDown()	{
		driver.close();
		driver.quit();
		
	}
}
