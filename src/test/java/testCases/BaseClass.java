package testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;


public class BaseClass {
	public static WebDriver driver;
	ReadConfig rconfig = new ReadConfig();
	public String baseurl = rconfig.getAppUrl();
	public String uname = rconfig.getUserName();
	public String pwd = rconfig.getPassword();
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brw) 
	{
		if(brw.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			logger= Logger.getLogger("ebanking");
			PropertyConfigurator.configure("log4j.properties");
		}
		else if(brw.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	@AfterClass
	public void tearDown()throws Throwable
	{
		Thread.sleep(5000);
		//driver.quit();
	}
	public void takeScreenShot(WebDriver driver, String testcasename) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String storagrpath = "./Screenshots/"+testcasename+".png";
		File trg = new File(storagrpath);
		FileUtils.copyFile(src, trg);
	}
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(6).toLowerCase();
		return generatedstring;
	}
	public String randomNumeric()
	{
		String generaedNumeric = RandomStringUtils.randomNumeric(5);
		return generaedNumeric;
	}

}
