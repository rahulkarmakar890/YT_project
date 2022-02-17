package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='uid']")
	WebElement txtUserName;
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement btnLogin;
	@FindBy(xpath="//a[@href='Logout.php']")
	WebElement linkLogout;
	
	
	public void setUsername(String username)
	{
		this.txtUserName.sendKeys(username);
	}
	public void setPassword(String password)
	{
		this.txtPassword.sendKeys(password);
	}
	public void clickLogin()
	{
		this.btnLogin.click();
	}
	public void clickLogout()
	{
		this.linkLogout.click();
	}

}
