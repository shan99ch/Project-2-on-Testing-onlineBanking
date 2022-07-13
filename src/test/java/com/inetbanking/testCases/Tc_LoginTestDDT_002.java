package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLtestdata;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class Tc_LoginTestDDT_002 extends BaseClass {
	
	
  @Test(dataProvider = "getdata")
  public void loginDDT(String username, String password) throws InterruptedException, IOException 
  {
	LoginPage lp = new LoginPage(driver); 
	lp.setUserName(username);
	logger.info("Username provided");
	lp.setPassWord(password);
	logger.info("Password provided");
	lp.clickSubmit();
	Thread.sleep(2000);
	
	if(IsAlertPresent()==true)
	{
		driver.switchTo().alert().accept(); // closing Alert
		driver.switchTo().defaultContent(); // handling Home page(parent) window
		captureScreen(driver, "LoginTest");
		Assert.assertTrue(false);  //indicates failed test case
		logger.warn("Login Failed");
		//captureScreen(driver, "LoginTest");
		
	}
	else
	{
		Assert.assertTrue(true);
		logger.info("Login passed");
		lp.clickLogout();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();  // closing Logout Alert
		driver.switchTo().defaultContent();
		
	}
  }
  
  
  public boolean IsAlertPresent()  // user defined method to check Alert is present or not
  {       // if alert is there it should return 'true' otherwise it should throw appropriate Exception msg // for that using try-catch here
	  try 
	  {
	  driver.switchTo().alert(); // checking for Alert
	  return true;
	  }
	  catch (NoAlertPresentException e)
	  {
		  return false;
	  }
	  
  }

  
  
  @DataProvider(name="getdata")
  public Object[][] getData() throws IOException 
  {
	  XLtestdata dd = new XLtestdata();
    return dd.getdata();
    }
  }

