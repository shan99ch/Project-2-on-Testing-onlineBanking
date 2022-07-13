package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class Tc_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userID);
		
		logger.info("username is entered");
		
		lp.setPassWord(userPW);
		
		logger.info("password is entered");
		lp.clickSubmit();
		
		// checking the HomePage name
		if(driver.getTitle().equalsIgnoreCase("Guru99 Bank manager Homepage"))
		{
			Assert.assertTrue(true);
			
			logger.info("TestCase is passed");
		}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			
			logger.info("TestCase is failed");
		}
		
	}

}
