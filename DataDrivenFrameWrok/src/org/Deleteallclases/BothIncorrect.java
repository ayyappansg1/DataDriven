package org.Deleteallclases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BothIncorrect {
	String[][]arr ={ {"ayyappan","ayyappan"},{"ayyappan","Ayyappan"},{"Ayyappan","ayyappan"},{"agagdnjfnjd","uafifb"}};
	
	@DataProvider(name="logindata")
	public String[][] logindataprovider() {
		return arr;
		
	}
	
	@Test(dataProvider="logindata")
	public void BothIncorrectes(String uname,String pword) {
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

}
