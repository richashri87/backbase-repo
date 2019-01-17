package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ReportUtil;

/*
 * This class consist all the methods which are related to adding new computer
 */

public class NewComputerPage {
	WebDriver driver;

	By pageHeaderContent = By.cssSelector(".main>h1");

	By name = By.id("name");
	By introduced = By.id("introduced");
	By Discontinued = By.id("discontinued");
	By company = By.id("company");
	By createButton = By.xpath("//input[@value='Create this computer']");
	By updateButton = By.xpath("//input[@value='Save this computer']");
	By deleteButton = By.xpath("//input[@value='Delete this computer']");
	By alertMsg = By.xpath("//div[@class='alert-message warning']");
	By addComputer = By.id("add");

	public NewComputerPage(WebDriver driver) {
		this.driver = driver;
	}

	public String findAlertORwarning() {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(addComputer));
		return driver.findElement(alertMsg).getText();
	}

	public void verify(String actual, String expected, String details)
	{
		if(actual.contains(expected))
		{ 
			ReportUtil.logPass(details);
			}		
		else
		{
			ReportUtil.logFail(details);
		}
	}	
public void addNewComputer(Properties propData){
		
		WebDriverWait wait= new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(name));
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(propData.getProperty("computerName"));
		driver.findElement(introduced).clear();
		driver.findElement(introduced).sendKeys(propData.getProperty("introduceDate"));
		driver.findElement(Discontinued).clear();
		driver.findElement(Discontinued).sendKeys(propData.getProperty("discontinuedDate"));
		
		WebElement mySelectElement=driver.findElement(company);
		Select dropdown= new Select(mySelectElement);
		dropdown.selectByVisibleText(propData.getProperty("companyName"));
		driver.findElement(createButton).click();
		verify(findAlertORwarning(),"Computer "+ propData.getProperty("computerName")+" has been created","Computer added successfully");	
		}

	public void updateComputer(Properties propData) {

		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(name));
		driver.findElement(introduced).clear();
		driver.findElement(introduced).sendKeys(propData.getProperty("updatedintroduceDate"));
		driver.findElement(Discontinued).clear();
		driver.findElement(Discontinued).sendKeys(propData.getProperty("updateddiscontinuedDate"));
		driver.findElement(updateButton).click();
		verify(findAlertORwarning(),"Computer "+ propData.getProperty("computerName")+" has been updated","Computer updated successfully");	
	}

	public void deleteComputer() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(name));
		driver.findElement(deleteButton).click();
		verify(findAlertORwarning(),"Computer has been deleted","Computer has been deleted");	
	}

}
