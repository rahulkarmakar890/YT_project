package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.loginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws Throwable
	{
		driver.get(baseurl);
		logger.info("url is opened");
		loginPage lp = new loginPage(driver);
		lp.setUsername(uname);
		logger.info("username entered");
		lp.setPassword(pwd);
		logger.info("password entered");
		lp.clickLogin();
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println(driver.getTitle());
			logger.info("Login test failed");
			takeScreenShot(driver, "loginTest");
		}
		
	}

}
