package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting implements ITestListener{
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public void onFinish(ITestContext arg0) 
	{
		reports.flush();	
	}
	public void onStart(ITestContext arg0) 
	{	
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportname = "./test-output/Extent-Report/"+timeStamp+".html";
		reports = new ExtentReports(reportname);
	}
	public void onTestSuccess(ITestResult arg0) 
	{
		test = reports.startTest("Passed test"+arg0.getName());
		test.log(LogStatus.PASS, arg0.getName());
	}
	public void onTestFailure(ITestResult arg0) 
	{
		test = reports.startTest("Failed test"+arg0.getName());
		test.log(LogStatus.FAIL, arg0.getName());
		String screenshotpath = "./Screenshots/"+arg0.getName()+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(screenshotpath);
		try 
		{
			FileUtils.copyFile(screen, target);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult arg0) 
	{	
		test= reports.startTest("Skiped test-"+arg0.getName());
		test.log(LogStatus.SKIP, arg0.getName());
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
			
	}
	public void onTestStart(ITestResult arg0) 
	{
		
	}
	
	
	
	

}
