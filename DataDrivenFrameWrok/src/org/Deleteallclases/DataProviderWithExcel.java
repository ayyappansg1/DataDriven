package org.Deleteallclases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataProviderWithExcel {
	
	WebDriver driver;
	String[][]data=null;
	
	@DataProvider(name="logindata")
	
	public String[][] logindataprovider() throws BiffException, IOException {
		data=getExcelData();
		return data;
	}
	
	
	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream file=new FileInputStream("E:\\Fileoperations\\usernamepassed.xls");
		Workbook workbook=Workbook.getWorkbook(file);
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int columns = sheet.getColumns();
		System.out.println(rows);
		System.out.println(columns);
		String[][]test=new String[rows-1][columns];
		for (int i = 1; i <rows; i++) 
		{
			for (int j = 0; j <columns; j++)
			{
				test[i-1][j]=sheet.getCell(j,i).getContents();
				
			}
		}
		System.out.println(test);
		return test;
		
	}
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\java files\\DataDrivenFrameWrok\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(dataProvider="logindata")
	public void bothIncorrectes(String uname,String pword) {
		
		driver.get("https://www.facebook.com/");
		
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(pword);
		WebElement login = driver.findElement(By.name("login"));
		login.click();
	}
	@AfterTest
	public void allclose() {
		driver.quit();
	}
		}


