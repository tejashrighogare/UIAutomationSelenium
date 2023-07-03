package allTestCases;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import configurationReader.ConfigReader;
import pageObject.PageObjectForOlympus;
import webDriver.WebDriverManagerBrowser;

public class OlympusDemositeLogin extends WebDriverManagerBrowser {
	private static WebDriver driver;
	private String url;
	PageObjectForOlympus pageObject;

	@BeforeClass
	public void setUp() {
		driver = getBrowser("edge");
		url = ConfigReader.getPropertyValue("baseURL");
		driver.get(url);
		pageObject = new PageObjectForOlympus(driver);
	}

	@Test(priority = 1, description = "Validate empty EmailId")
	public void emptyEmailID() {
		pageObject.setEmailid("");
		String readPassword = ConfigReader.getPropertyValue("password");
		pageObject.setPassword(readPassword);
		pageObject.signIn();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getEmailID = pageObject.email.getText();
			if (getEmailID.equals(""))
				assertEquals(false, "EmailId is required.");
		}
	}

	@Test(priority = 2, description = "Validate empty Password")
	public void emptyPassword() {
		String readEmailId = ConfigReader.getPropertyValue("emailID");
		pageObject.setEmailid(readEmailId);
		pageObject.setPassword("");
		pageObject.signIn();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getPassword = pageObject.password.getText();
			if (getPassword.equals(""))
				assertEquals(false, "Password is required.");
		}
	}

	@Test(priority = 3, description = "Validate empty EmailID and Password")
	public void emptyEmailIDPassword() {
		pageObject.setEmailid("");
		pageObject.setPassword("");
		pageObject.signIn();
		String expectedUrl = driver.getCurrentUrl();
		if (url.equals(expectedUrl)) {
			String getEmailID = pageObject.email.getText();
			String getPassword = pageObject.password.getText();
			if (getPassword.equals("") && getEmailID.equals(""))
				assertEquals(false, "EmailId and Password is required.");
		}
	}

	@Test(priority = 4, description = "Validate Valid EmailID and Password")
	public void validEmaiIDPassword() {
		String readEmailId = ConfigReader.getPropertyValue("emailID");
		pageObject.setEmailid(readEmailId);
		String readPassword = ConfigReader.getPropertyValue("password");
		pageObject.setPassword(readPassword);
		pageObject.signIn();
		String expectedUrl = "https://www.olympus-ims.com/en/login/?";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.close();
	}
}