/**
 * 
 */
package testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import util.LoadProperties;

/**
 * @author richa This class performs activities related to start up and tear
 *         down
 */
public class BaseClassTest {
	WebDriver driver;
	public static Properties propData;
	public static LoadProperties properties;
	static {
		try {
			properties = new LoadProperties();
			propData = properties.loadProperties("parent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	@Parameters("browser")
	public void setup(String browser) {
		Reporter.log("Driver session started", true);
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver2");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(propData.getProperty("url"));
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(propData.getProperty("url"));
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		Reporter.log("application started", true);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
