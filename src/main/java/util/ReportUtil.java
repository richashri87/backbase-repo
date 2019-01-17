package util;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ReportUtil {

	/**
	 * The WebDriver driver
	 */
	public static WebDriver driver;

	/**
	 * This method is called whenever a test case passes
	 * 
	 * @param detail
	 *            the detial for passed test case
	 */
	public static void logPass(String detail) {
		Assert.assertTrue(true, detail);
	}

	/**
	 * This method is called whenever a test case fails
	 * 
	 * @param detail
	 *            the detail for failed test case
	 */
	public static void logFail(String detail) {
		    Assert.assertTrue(false, detail);

	}

}
