package testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.loginPage;
import utilities.ExcelUtils;

public class TC_LoginDDT_001 extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password)
	{
		loginPage lp = new loginPage(driver);
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickLogin();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Success");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws Throwable
	{
		String path= "./TestData/Login_Data.xlsx";
		ExcelUtils xl = new ExcelUtils(path);
		int rownum = xl.getRowCount("login");
		int cellnum = xl.getCellCount("login", 0);
		String logindata[][]= new String [rownum][cellnum];
		for(int i=1; i<rownum; i++)
		{
			for(int j=0; j<cellnum; j++)
			{
				logindata[i-1][j] = xl.getCelldata("login", i, j);
			}
		}
		
		return logindata;
	}

}
