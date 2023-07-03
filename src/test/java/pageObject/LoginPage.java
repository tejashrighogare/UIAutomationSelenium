package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver localDriver;
	public LoginPage(WebDriver remoteDriver)
	{
		localDriver=remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(linkText="Sign In")
	WebElement signInButton;
	
	public void setEmailid(String setEmailid)
	{
		email.sendKeys(setEmailid);
	}
	
	public void setPassword(String setPassword)
	{
		password.sendKeys(setPassword);
	}
	public void signIn()
	{
		signInButton.click();
	}
}
