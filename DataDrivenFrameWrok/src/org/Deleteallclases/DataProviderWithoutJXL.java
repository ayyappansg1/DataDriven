package org.Deleteallclases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.Main;

public class DataProviderWithoutJXL {
	static List<String> usernameList=new ArrayList<String>();
	static List<String> passwordlist=new ArrayList<String>();


	public void readExcel() throws IOException {
		FileInputStream files=new FileInputStream("E:\\Fileoperations\\withpoi.xlsx");
		Workbook workbook=new XSSFWorkbook(files);
		Sheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rowiterator = sheet.iterator();
		while(rowiterator.hasNext()) {
			Row rowinside =rowiterator.next();
			Iterator<Cell> iterator2 = rowinside.iterator();		
			int i=2;
			while(iterator2.hasNext()) {
				if(i%2==0) {
					usernameList.add(iterator2.next().getStringCellValue());
				}else {
					passwordlist.add(iterator2.next().getStringCellValue());
				}
				i++;
			}
		}
	}

		public void login(String uname,String pword) {
			System.setProperty("webdriver.chrome.driver", "E:\\java files\\DataDrivenFrameWrok\\Driver\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.facebook.com/");
			
			WebElement username=driver.findElement(By.id("email"));
			username.sendKeys(uname);
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys(pword);
			WebElement login = driver.findElement(By.name("login"));
			login.click();
			driver.quit();
		}

		public static void main(String[]args) throws IOException {
			DataProviderWithoutJXL sangar=new DataProviderWithoutJXL();
			sangar.readExcel();
			System.out.println("Username list "+usernameList);
			System.out.println("Password List "+passwordlist);
			for(int i=0;i<usernameList.size();i++) {
				sangar.login(usernameList.get(i), passwordlist.get(i));
			}
			
			
			
		}


	}
