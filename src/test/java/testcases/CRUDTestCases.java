package testcases;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.NewComputerPage;
import util.LoadProperties;

public class CRUDTestCases extends BaseClassTest{
	public static HomePage homepg;
	public static NewComputerPage newComputerPage;
	public static  Properties propData;
	public static LoadProperties properties;
	/**
	* loading data once 
	* 
	* @return null
	*/
	static
	{
	try {
	properties = new LoadProperties();
	propData = properties.loadProperties("data");
	} catch (IOException e) {
	e.printStackTrace();
	}
	}

	
	/**
	 * verify new computer added
	 * 
	 * @return null
	 */
	@Test(priority=1)
	public void verifyNewComputerAddedSuccessfully()
	{
		homepg = new HomePage(driver);
		homepg.clickAddComputer();
		
		newComputerPage = new NewComputerPage(driver);
		newComputerPage.addNewComputer(propData);
	}

	/**
	 * verify search
	 * 
	 * @return null
	 */
	@Test(priority=2)
	public void verifySearch()
	{
		homepg = new HomePage(driver);
		homepg.searchForComputer(propData);
	}
	
	/**
	 * verify computer detail updated successfully
	 * 
	 * @return null
	 */
	@Test(priority=3)
	public void verifyComputerDetailsUpdatedSuccessFully()
	{
		homepg = new HomePage(driver);
		
		if(homepg.searchForComputer(propData)){
		homepg.selectComputer(propData);
		newComputerPage = new NewComputerPage(driver);
		newComputerPage.updateComputer(propData);
	}
	else{
	    //please add computer detailsß
		
	}
}
	
	/**
	 * verify computer delete successfully
	 * 
	 * @return null
	 */
	@Test(priority=4)
	public void verifyComputerDeletedSuccessfully()
	{
		homepg = new HomePage(driver);
		if(homepg.searchForComputer(propData)){
		homepg.selectComputer(propData);
		newComputerPage = new NewComputerPage(driver);
		newComputerPage.deleteComputer();
	}
	else{
	    //please add computer detailsß
		
	}
	}

}
