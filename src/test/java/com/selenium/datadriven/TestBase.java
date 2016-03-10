package com.selenium.datadriven;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.datadriven.page.TopMenu;
import com.selenium.datadriven.util.Constants;
import com.selenium.datadriven.util.Xls_Reader;

public class TestBase {
	
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static Xls_Reader xls = null;
	public static boolean isLoggedin = false;
	public static TopMenu topMenu = null;
	
	public static void initXlsReader(){
		xls = new Xls_Reader(Constants.xls_filePath);
	}
	
	public static void initConfiguration(){
		CONFIG= new Properties();
		if(CONFIG != null){
			
		try{			
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\CONFIG.properties");
		CONFIG.load(fis);
		//System.out.println(CONFIG.getProperty("URL_Name"));
		}catch(Throwable thro){
			System.out.println("Cann't find config "+ thro.getMessage());
			
		}
	}
}	
	
	public static void initDriver(String browserType){
		
		if(browserType.equals("Mozilla")){
			driver = new FirefoxDriver();
		}else if (browserType.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browserType.equals("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	
	public TopMenu getTopMenu(){
		if(topMenu == null){
			topMenu = PageFactory.initElements(driver, TopMenu.class);
		}
		return topMenu;
	}
	
	public void quitDriver(){
		driver.quit();
		driver = null;
		
	}
	
   }