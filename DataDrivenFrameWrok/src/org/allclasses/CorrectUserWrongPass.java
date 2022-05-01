package org.allclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CorrectUserWrongPass {

	@Test
	@Parameters({"username","password"})
	public void CorrectUserWrongPasses(String uname,String pword) {
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
