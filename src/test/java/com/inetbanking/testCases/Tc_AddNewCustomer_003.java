package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class Tc_AddNewCustomer_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws IOException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userID);
		logger.info("usename is entered");
		lp.setPassWord(userPW);
		logger.info("password is entered");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		acp.clickAddCustomerLink();
		acp.sendCustomerName("suchithra");
		acp.customerGender("female");
		acp.customerDob("06", "09", "1996");
		Thread.sleep(3000);
		acp.customerAddress("1942 Venkateswara colony");
		acp.customerCity("Hyd");
		acp.customerState("Telangana");
		acp.customerPincode("57327");
		acp.customerPhone("986778901");
		
		// there is a restriction on email ID, everytime every consumer will have a unique email id. if u hardcode Email-Id 1st time test will pass but from 2nd time test fails. each time we have to generate email_Id dynamically.
		String email = randomString()+"@gmail.com";
		acp.customerEmailID(email);
		acp.customerPassword("abc236");
		acp.clickSubmit();
		
		Thread.sleep(3000);
		
		boolean checkpage = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(checkpage == true)
		{
			Assert.assertTrue(true); // test is passed
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString()  // user defined method for email bcaz domain of email is static but 1st few letters feequently changes
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return generatedString;
	}

}
