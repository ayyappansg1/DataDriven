package org.Deleteallclases;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.naming.ldap.ExtendedResponse;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReport {
	WebDriver driver;
	ExtentReports extentreport;
	ExtentHtmlReporter htmlreporter;
	ExtentTest testcase;

	@Test
	public void openGoogle() throws IOException {
		testcase=extentreport.createTest("Verifying google");
		testcase.log(Status.INFO, "Navigating to");
		testcase.log(Status.INFO, "This is for Showing many design of reports");
		driver.get("https://www.google.co.in");
		testcase.log(Status.INFO, "ACtual title"+driver.getTitle());
		testcase.log(Status.INFO, "Google");
		if(driver.getTitle().equals("Ggle")) {
			testcase.log(Status.PASS, "ACtual case passes");
		}else {
			testcase.log(Status.FAIL, "ACtual case Failed");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			File source=new File("googleimage.png");
			org.openqa.selenium.io.FileHandler.copy(screenshotAs, source);
			testcase.addScreenCaptureFromPath("googleimage.png");
		}

	}
	@Test
	public void openWiki() throws IOException {
		testcase=extentreport.createTest("Verifying Wikipedia");
		testcase.log(Status.INFO, "Navigating to");
		testcase.log(Status.INFO, "This is for Showing many design of reports");
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		testcase.log(Status.INFO, "ACtual title"+driver.getTitle());
		testcase.log(Status.INFO, "Google");
		if(driver.getTitle().contains("Wki")) {
			testcase.log(Status.PASS, "ACtual case passes");
		}else {
			testcase.log(Status.FAIL, "ACtual case Failed");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			File source=new File("googleimage.png");
			org.openqa.selenium.io.FileHandler.copy(screenshotAs, source);
			testcase.addScreenCaptureFromPath("googleimage.png");
		}
	}
	@Test
	public void openFacebook() throws IOException {
		testcase=extentreport.createTest("Verifying facebook");
		testcase.log(Status.INFO, "Navigating to");
		testcase.log(Status.INFO, "This is for Showing many design of reports");
		driver.get("https://www.facebook.com");
		testcase.log(Status.INFO, "ACtual title"+driver.getTitle());
		testcase.log(Status.INFO, "Facebook");
		if(driver.getTitle().contains("Facebook")) {
			testcase.log(Status.PASS, "ACtual case passes");
		}else {
			testcase.log(Status.FAIL, "ACtual case Failed");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			File source=new File("facebbokimage.png");
			org.openqa.selenium.io.FileHandler.copy(screenshotAs, source);
			testcase.addScreenCaptureFromPath("facebbokimage.png");
		}}

	@BeforeSuite
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\java files\\DataDrivenFrameWrok\\Driver\\chromedriver.exe");
		extentreport=new ExtentReports();
		htmlreporter=new ExtentHtmlReporter("E:\\ExtentedReport.html");
		extentreport.attachReporter(htmlreporter);
		driver=new ChromeDriver();

	}
	@AfterSuite
	public void close() {
		
		driver.quit();
		extentreport.flush();
	}
}
