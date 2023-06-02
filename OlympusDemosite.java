package allTestCases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OlympusDemosite {
	private static WebDriver driver;
	private static String baseURL = "https://www.olympus-ims.com/en/login/";
	private static String emailID = "admin@abc.com";
	private static String password = "Admin@123";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void emptyEmailID() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("inputWidth")).sendKeys("");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (baseURL.equals(expectedUrl)) {
			String getEmailID = driver.findElement(By.id("inputWidth")).getText();
			if (getEmailID.equals(""))
				assertEquals(false, "EmailId is required.");
		}
	}

	@Test(priority = 2)
	public void emptyPassword() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("inputWidth")).sendKeys(emailID);
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys();
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (baseURL.equals(expectedUrl)) {
			String getPassword = driver.findElement(By.cssSelector("input[type = 'password']")).getText();
			if (getPassword.equals(""))
				assertEquals(false, "Password is required.");
		}
	}

	@Test(priority = 3)
	public void emptyEmailIDPassword() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("inputWidth")).sendKeys("");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys("");
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (baseURL.equals(expectedUrl)) {
			String getEmailID = driver.findElement(By.id("inputWidth")).getText();
			String getPassword = driver.findElement(By.cssSelector("input[type = 'password']")).getText();
			if (getPassword.equals("") && getEmailID.equals(""))
				assertEquals(false, "EmailId and Password is required.");
		}
	}

	@Test(priority = 4)
	public void validEmaiIDPassword() {
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.findElement(By.id("inputWidth")).sendKeys(emailID);
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = "https://www.olympus-ims.com/en/login/?";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
	}
}