package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.NewCustomerPage;
import pageobjects.loginPage;

public class TC_AddCustomer_002 extends BaseClass{

	@Test
	public void addNewCustomer() throws Throwable
	{
		loginPage lp = new loginPage(driver);
		lp.setUsername(uname);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("password entered");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		NewCustomerPage ncp = new NewCustomerPage(driver);
		
		ncp.clickNewCustomer();
		
		logger.info("Providing new customer details");
		
		ncp.enterCustomerName("Rahul");
		ncp.clickGender();
		ncp.enterDOB("04", "01", "1966");
		ncp.enterAddress("India");
		ncp.enterCity("cuttack");
		ncp.enterState("Odisha");
		ncp.enterPincode("754023");
		ncp.enterTphoneNum("8908904339");
		String email= randomString()+"@gmail.com";
		ncp.enterEmail(email);
		ncp.clicksubmitbtn();
		
		
		logger.info("Validation started");
		
		boolean res= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			logger.info("Test case failed");
			takeScreenShot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	
}
