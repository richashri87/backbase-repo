/**
 * 
 */
package pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author richa This class consist all the methods which are related to Home
 *         Page
 */
public class HomePage {

	WebDriver driver;

	By addComputer = By.id("add");
	By alertMsg = By.xpath("//div[@class='alert-message warning']");
	By searchBox = By.id("searchbox");
	By searchButton = By.id("searchsubmit");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddComputer() {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(addComputer));
		driver.findElement(addComputer).click();
	}
	
	public boolean searchForComputer(Properties propData) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(addComputer));
		driver.findElement(searchBox).sendKeys(propData.getProperty("computerName"));
		driver.findElement(searchButton).click();
		
		By searchedComputer = By.linkText(propData.getProperty("computerName"));
		if(driver.findElement(searchedComputer).isDisplayed()){
			return true;
		}
		return false;
	}
	public void selectComputer(Properties propData)
	{
		By selectComputer=By.linkText(propData.getProperty("computerName"));
		driver.findElement(selectComputer).click();
	}
}
