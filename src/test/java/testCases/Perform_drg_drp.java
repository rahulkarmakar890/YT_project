package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobjects.Drag_Drop;

public class Perform_drg_drp {
	WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		//driver.switchTo().frame(0);
	}
	@Test
	public void action() throws Throwable
	{
		Drag_Drop dd= new Drag_Drop(driver);
		Thread.sleep(5000);
		dd.drgdrp();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}

}
