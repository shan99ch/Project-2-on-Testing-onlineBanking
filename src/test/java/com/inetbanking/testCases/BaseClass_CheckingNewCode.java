package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfigProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_CheckingNewCode {
	
ReadConfigProperties readconfig = new ReadConfigProperties(); //importing readconfigproperties class from com.inetbanking.utilities Package
	
	public String URL = readconfig.getApplicationURL();
	public String userID = readconfig.getUserName();
	public String userPW = readconfig.getPassword();
	WebDriver driver;
	Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)  // argument String br represents @parameters ("browser")
	{
	
	logger= logger.getLogger("BaseClass");
	PropertyConfigurator.configure("log4j.properties");
	
	if(br.equals("chrome"))
	{
		ChromeOptions chromeoptions = new ChromeOptions(); // chromeOptions generates System Environment like browser, version, OS etc
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeoptions);
		driver.manage().window().maximize();
		logger.info("Chrome browser opened by WebDriverManager");
	}
	else if (br.equals("firefox"))
	{
		FirefoxOptions firefoxoptions = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver(firefoxoptions);
		driver.manage().window().maximize();
		logger.info("Firefox browser opened by WebDriverManager");
	}
	else if (br.equals("ie"))
	{
		InternetExplorerOptions internetexploreroptions = new InternetExplorerOptions();
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver(internetexploreroptions);
		logger.info("InternetExplorer browser opened by WebDriverManager");
	}
	driver.get(URL);
	logger.info("URL is opened");
	}

	@AfterClass
	public void teardown()
	{
		driver.close();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png"));
	}

}
