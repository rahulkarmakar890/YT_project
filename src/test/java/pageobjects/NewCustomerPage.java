package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	WebDriver driver;
	public NewCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='addcustomerpage.php']")
	WebElement linkNewCustomer;
	@FindBy(xpath="//input[@name='name']")
	WebElement txtCustomername;
	@FindBy(xpath="(//input[@name='rad1'])[1]")
	WebElement clickGender;
	@FindBy(xpath="(//input[@name='dob'])")
	WebElement txtDob;
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement txtAddress;
	@FindBy(xpath="//input[@name='city']")
	WebElement txtCity;
	@FindBy(xpath="//input[@name='state']")
	WebElement txtState;
	@FindBy(xpath="//input[@name='pinno']")
	WebElement txtPincode;
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement txtTphoneNum;
	@FindBy(xpath="//input[@name='emailid']")
	WebElement txtEmail;
	@FindBy(xpath="//input[@name='sub']")
	WebElement btnSubmit;
	
	
	public void clickNewCustomer()
	{
		this.linkNewCustomer.click();
	}
	public void enterCustomerName(String customername)
	{
		this.txtCustomername.sendKeys(customername);
	}
	public void clickGender()
	{
		this.clickGender.click();
	}
	public void enterDOB(String dd, String mm, String yy)
	{
		this.txtDob.sendKeys(dd);
		this.txtDob.sendKeys(mm);
		this.txtDob.sendKeys(yy);
	}
	public void enterAddress(String address)
	{
		this.txtAddress.sendKeys(address);
	}
	public void enterCity(String city)
	{
		this.txtCity.sendKeys(city);
	}
	public void enterState(String state)
	{
		this.txtState.sendKeys(state);
	}
	public void enterPincode(String pincode)
	{
		this.txtPincode.sendKeys(pincode);
	}
	public void enterTphoneNum(String phonenum)
	{
		this.txtTphoneNum.sendKeys(phonenum);
	}
	public void enterEmail(String email)
	{
		this.txtEmail.sendKeys(email);
	}
	public void clicksubmitbtn()
	{
		this.btnSubmit.click();
	}

}
