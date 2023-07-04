package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectForOlympus {
	WebDriver localDriver;
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
		password.sendKeys(setPassword);
	}

	public void signInButton() {
		signInButton.click();
	}
}