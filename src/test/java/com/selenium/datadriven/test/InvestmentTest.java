package com.selenium.datadriven.test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

public class InvestmentTest extends TestBase{
	
	@BeforeTest
	public void beforeTest(){
		//initConfiguration();
		//initDriver();
		initXlsReader();
	}
	
	@Test(dataProvider ="getData")
	public void investmentTest(Hashtable<String, String> data) throws InterruptedException{

		if (!Utility.isTestRunable("InvestmentTest", xls) || data.get("Runmode").equals("N")){
			throw new SkipException("Skipping the test");
		}else{
			initConfiguration();
			initDriver(data.get(Constants.BROWSERTYPE_COL));
			driver.get(CONFIG.getProperty("URL_Name"));
	}
		System.out.println("***************************");
		//Object resultPage = Utility.logIn_Application();
		LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
		LoginPage loginPage = lp.gotoLoginPage();
		Object resPage = loginPage.doLogin(CONFIG.getProperty("defaultUserName"), CONFIG.getProperty("defaultPassword"));
	    Thread.sleep(4000);
	    if(resPage instanceof LoginPage){
	    	Assert.fail("Not able to login");
	    }
        
	    MyPortFolioPage portfolioPage = (MyPortFolioPage)resPage;
	    portfolioPage.selectFromDropdown("Mohammad PortFollio");
	    Thread.sleep(3000);
	    portfolioPage.addStock(data.get(Constants.CONAME_COL), data.get(Constants.PDATE_COL), data.get(Constants.STOCKQTY_COL), data.get(Constants.STOCKPRICE_COL));
	    Thread.sleep(3000);
	    getTopMenu().signOut();
   
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] data = Utility.getData("InvestmentTest", xls);
		return data;
		
	}
	@AfterTest
	public void quitDriver(){
		if(driver!=null)
			driver.quit();
	}
}
