package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement LinkAddCustomer;
	
	@FindBy (how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy (how = How.XPATH, using = "//input[@name='rad1']")
	@CacheLookup
	WebElement rbGender;
	
	@FindBy (how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDob;
	
	@FindBy (how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddr;
	
	@FindBy (how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy (how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy (how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPin;
	
	@FindBy (how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtPhone;
	
	@FindBy (how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy (how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy (how = How.NAME, using = "res")
	@CacheLookup
	WebElement btnReset;
	
	public void clickAddCustomerLink()
	{
		LinkAddCustomer.click();
	}
	
	public void sendCustomerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void customerGender(String cgender) 
	{
		rbGender.click();
	}
	
	public void customerDob(String mm, String dd, String yy)
	{
		txtDob.sendKeys(mm);	
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	
	public void customerAddress(String caddress)
	{
		txtAddr.sendKeys(caddress);
	}
	public void customerCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void customerPincode(String cpin)  // int cpin => integer value
	{
		txtPin.sendKeys(cpin);            //String.valueof(cpin) => converting integer into String since sendkeys accepts only String values
	}
	
	public void customerState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void customerPhone(String cphone)
	{
		txtPhone.sendKeys(cphone);
	}
	
	public void customerEmailID(String cemail)
	{
		txtEmail.sendKeys(cemail);
	}
	
	public void customerPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}

}
