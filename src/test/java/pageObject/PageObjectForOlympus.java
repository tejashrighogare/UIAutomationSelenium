package pageObject;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectForOlympus {
	
	private WebDriver localDriver;

	public PageObjectForOlympus(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

	@FindBy(id = "inputWidth")
	public WebElement email;
	
	@FindBy(css = "input[type = 'password']")
	public WebElement password;
	
	@FindBy(css = "input[type = 'submit']")
	public WebElement signInButton;

	public void sendEmaiId(String setEmailid) {
			email.sendKeys(setEmailid);
	}

	public void SendPassword(String setPassword) {
		byte[] decrypt = Base64.getDecoder().decode(setPassword);
		String encodePassword = new String(decrypt);
		password.sendKeys(encodePassword);
	}

	public void signInButton() {
		signInButton.click();
	}
	public void sendEmailPassword(String emailID, String setPassword)
	{
		sendEmaiId(emailID);
		SendPassword(setPassword);
		signInButton();
		}
}