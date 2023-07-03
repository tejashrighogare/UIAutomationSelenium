package allTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

public class BaseClass {
	public String baseURL = "https://www.contactdirect.com/";
	public String userName = "tejashri.ghogare@encora.com";
	public String password = "Encora@!Q77";
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}