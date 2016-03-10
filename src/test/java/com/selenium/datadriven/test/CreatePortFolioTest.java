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
import com.selenium.datadriven.page.MyPortFolioPage;
import com.selenium.datadriven.util.Constants;
import com.selenium.datadriven.util.Utility;

public class CreatePortFolioTest extends TestBase{
	@BeforeTest
	public void beforeTest(){
		initXlsReader();
	}
	
	@Test(dataProvider="getData")
	public void createPortfolio(Hashtable<String, String> data) throws InterruptedException{
		
		if(!Utility.isTestRunable("CreatePortFolioTest", xls) || data.get("Runmode").equals("N")){
			throw new SkipException("Skipping the test");
		}else{
			initConfiguration();
			initDriver(data.get(Constants.BROWSERTYPE_COL));
			driver.get(CONFIG.getProperty("URL_Name"));
		}
	//System.out.println("**********************");
		Object resultPage = Utility.logIn_Application();
	/*LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
	LoginPage loginPage = lp.gotoLoginPage();
	Object resultPage = loginPage.doLogin(CONFIG.getProperty("defaultUserName"), CONFIG.getProperty("defaultPassword"));
    Thread.sleep(4000);
    if(resultPage instanceof LoginPage){
    	Assert.fail("Not able to login");
    }*/
    System.out.println(resultPage);
	MyPortFolioPage pfolio = PageFactory.initElements(driver, MyPortFolioPage.class);
    pfolio.createPortfolio(data.get(Constants.PFNAME_COL));
    Thread.sleep(4000);
    boolean portfolioRes = pfolio.isDropdownSelected(data.get(Constants.PFNAME_COL));
    try{
    Assert.assertTrue(portfolioRes, "Portfolio not created");
    }catch (Exception e){
    	System.out.println(e.getMessage());
    }
    Thread.sleep(4000);
    
    pfolio.getMenu().signOut();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = Utility.getData("CreatePortFolioTest", xls);
		
		return data;
		
	}
	@AfterTest
	public void quitDriver(){
		if(driver!=null)
			driver.quit();
	}

}
