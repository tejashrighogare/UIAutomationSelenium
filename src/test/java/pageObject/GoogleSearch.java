package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
	WebDriver driver=null;
	By textboxSearch=By.id("input");
	By buttonLogin=By.name("btnk");

	public void setText(String textSearch)
	{
	driver.findElement(textboxSearch).sendKeys(textSearch);
	}
	public void clickSearchButton()
	{
	driver.findElement(buttonLogin).sendKeys(Keys.RETURN);
	}
}

