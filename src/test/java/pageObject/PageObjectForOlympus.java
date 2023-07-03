package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
	@FindBy(how = How.CSS, using = "input[type = 'submit']")
	public WebElement signInButton;

	public void setEmailid(String setEmailid) {
		email.sendKeys(setEmailid);
	}

	public void setPassword(String setPassword) {
		password.sendKeys(setPassword);
	}

	public void signIn() {
		signInButton.click();
	}
}