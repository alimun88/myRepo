package com.selenium.datadriven.test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.datadriven.TestBase;
import com.selenium.datadriven.page.LaunchPage;
import com.selenium.datadriven.page.LoginPage;
import com.selenium.datadriven.page.MyPortFolioPage;
import com.selenium.datadriven.util.Constants;
import com.selenium.datadriven.util.Utility;

public class LoginTest extends TestBase{
	
	@BeforeTest
	public void beforeTest(){
		initXlsReader();
	}
	
	@Test(dataProvider="getData")
	
	public void loginTest(Hashtable<String, String> data) throws InterruptedException{
		if(!Utility.isTestRunable("LoginTest", xls) || data.get("Runmode").equals("N")){
				throw new SkipException("Skipping the test");
		}else{
			initConfiguration();
			initDriver(data.get(Constants.BROWSERTYPE_COL));
			driver.get(CONFIG.getProperty("URL_Name"));
	}
		//System.out.println("-----------------");
		
			LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
			LoginPage loginPage = lp.gotoLoginPage();
			Object resultPage = loginPage.doLogin(data.get(Constants.USENAME_COL), data.get(Constants.PASSWORD_COL));
		    Thread.sleep(4000);
		    if(resultPage instanceof LoginPage){
		    	System.out.println("Not Logged in");
		    }else if (resultPage instanceof MyPortFolioPage){
		    	System.out.println("Logged in");
		    }
		    
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data = Utility.getData(Constants.LOGIN_TEST, xls);
		return data;
	}
		    
	
	@AfterTest
	public void quitDriver(){
		if(driver!=null)
			driver.quit();
	}

}
