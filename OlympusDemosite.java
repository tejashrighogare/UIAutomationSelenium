package allTestCases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OlympusDemosite extends WebDriverManagerBase {
	private static WebDriver driver;
	private String url;

	@BeforeClass
	public void setUp() {
		driver = getBrowser("edge");
		url = ConfigReader.getPropertyValue("baseURL");
		driver.get(url);
	}

	@Test(priority = 1, description = "Validate empty EmailId")
	public void emptyEmailID() {
		driver.findElement(By.id("inputWidth")).sendKeys("");
		String readPassword = ConfigReader.getPropertyValue("password");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(readPassword);
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getEmailID = driver.findElement(By.id("inputWidth")).getText();
			if (getEmailID.equals(""))
				assertEquals(false, "EmailId is required.");
		}
	}

	@Test(priority = 2, description = "Validate empty Password")
	public void emptyPassword() {
		String readEmailId = ConfigReader.getPropertyValue("emailID");
		driver.findElement(By.id("inputWidth")).sendKeys(readEmailId);
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys();
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getPassword = driver.findElement(By.cssSelector("input[type = 'password']")).getText();
			if (getPassword.equals(""))
				assertEquals(false, "Password is required.");
		}
	}

	@Test(priority = 3, description = "Validate empty EmailID and Password")
	public void emptyEmailIDPassword() {
		driver.findElement(By.id("inputWidth")).sendKeys("");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys("");
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getEmailID = driver.findElement(By.id("inputWidth")).getText();
			String getPassword = driver.findElement(By.cssSelector("input[type = 'password']")).getText();
			if (getPassword.equals("") && getEmailID.equals(""))
				assertEquals(false, "EmailId and Password is required.");
		}
	}

	@Test(priority = 4, description = "Validate Valid EmailID and Password")
	public void validEmaiIDPassword() {
		String readEmailId = ConfigReader.getPropertyValue("emailID");
		driver.findElement(By.id("inputWidth")).sendKeys(readEmailId);
		String readPassword = ConfigReader.getPropertyValue("password");
		driver.findElement(By.cssSelector("input[type = 'password']")).sendKeys(readPassword);
		driver.findElement(By.cssSelector("input[type = 'submit']")).click();
		String expectedUrl = "https://www.olympus-ims.com/en/login/?";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
	}
}