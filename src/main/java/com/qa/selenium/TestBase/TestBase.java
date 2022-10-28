package com.qa.selenium.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties pro;
	
	public TestBase(){
		try {
		pro=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\SeleniumParactise\\src\\main\\java\\com\\qa\\selenium\\Config\\Config.properties");
		pro.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();		
		}
		catch(IOException e) {	
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
	String Browsername=pro.getProperty("browser");
	if(Browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\SeleniumParactise\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.get(pro.getProperty("URL"));
	    }
	}
}
