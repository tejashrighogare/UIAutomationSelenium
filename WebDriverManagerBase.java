package allTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerBase {
	
	public WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		return driver;
	}

	public WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}