package com.inetbanking.utilities;
// Read Common Values from Properties file
// It's Just like PageObject class (POM)
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {
	
	Properties pro = new Properties();
	
	public ReadConfigProperties()   // constructor to read properties file (config.proeperties)
	{
	File prof = new File("./Configurations/config.properties");
	FileInputStream profis;
	try {                     // since we r importing this constructor to other class we should use 'try-catch' not  'throw exceptions' 
		profis = new FileInputStream(prof);
		pro.load(profis);  // declare pro.load try-catch exception within the  fileinputstream's try-catch exception
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
	
	public String getApplicationURL()  // using return type Method to read this value in another classes
	{
		String URL = pro.getProperty("Url");
		return URL;	
	}
	
	public String getUserName()
	{
		String username = pro.getProperty("userID");
		return username;
	}
	
	public String getPassword()
	{
		String password = pro.getProperty("userPW");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chrome");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath = pro.getProperty("firefox");
		return firefoxpath;
	}
	
	public String getInternetExplorerPath()
	{
		String iepath = pro.getProperty("ie");
		return iepath;
	}

}
