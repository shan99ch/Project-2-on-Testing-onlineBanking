package com.inetbanking.utilities;

// Listener Class used to generate Extent Report.
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport_Listerners extends TestListenerAdapter {
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent ;
	public ExtentTest parenttest;
	public ExtentTest childtest;
	
	
	public void onStart(ITestContext testContext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // import date Java.Util
		String repname = "Test-Report-"+ timestamp +".html"; // due to that timestamp new report will be generated otherwise report will be overridden.
		
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repname); // report location
		try {
			sparkreporter.loadXMLConfig(System.getProperty("user.dir")+"/SparkReport.xml/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Host Name", "localhost"); // extent.setSystemInfo(timestamp, repname);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Shanthi");
		
		sparkreporter.config().setDocumentTitle("InetBanking Test Project"); // Title of Report
		sparkreporter.config().setReportName("Functional Test Report"); // Name of the Report
		sparkreporter.config().setTheme(Theme.DARK);
		
	}

	
	public void onTestSuccess(ITestResult tr) {
		parenttest = extent.createTest(tr.getName());
		parenttest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		//childtest.fail("passed test: " +tr.getName());
		
		
	}

	
	public void onTestFailure(ITestResult tr) {
		parenttest = extent.createTest(tr.getName());
		parenttest.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		
		String screenshotpath = System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+".png";
		File f = new File(screenshotpath);
		
		if(f.exists())
		{
			parenttest.fail("ScreenShot is below:"+ parenttest.addScreenCaptureFromPath(screenshotpath));
		}
		
		
	}

	

	
	public void onTestSkipped(ITestResult tr) {
		parenttest=extent.createTest(tr.getName());
		parenttest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}


	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

	

}
