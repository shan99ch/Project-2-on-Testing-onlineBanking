package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)  // constructor
	{
		this.driver = driver;
	}
By username =By.xpath("//input[@name='uid']");
By password = By.xpath("//input[@name='password']");
By login = By.xpath("//input[@name='btnLogin']");
By reset = By.xpath("//input[@name='btnReset']");
By logout =By.xpath("/html/body/div[3]/div/ul/li[15]/a");

public void setUserName(String ID)
{
	driver.findElement(username).sendKeys(ID);
}

public void setPassWord(String PW)
{
	driver.findElement(password).sendKeys(PW);
}

public void clickSubmit()
{
	driver.findElement(login).click();
}

public void clickReset()
{
	driver.findElement(reset).clear();
}

public void clickLogout()
{
	driver.findElement(logout).click();
}
}
