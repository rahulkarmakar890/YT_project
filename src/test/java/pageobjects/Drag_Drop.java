package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Drag_Drop {
	WebDriver driver;
	public Drag_Drop(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="draggable")
	WebElement drg;
	@FindBy(id="droppable")
	WebElement drp;

	public void drgdrp()
	{
		driver.switchTo().frame(0);
		Actions ac = new Actions(driver);
		ac.dragAndDrop(drg, drp).perform();
	}

}
