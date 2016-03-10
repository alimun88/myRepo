package com.selenium.datadriven.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.selenium.datadriven.util.Constants;

public class LaunchPage extends BasePage {
	
	public LaunchPage (WebDriver dr){
		super(dr);
	}
	
	
	public LoginPage gotoLoginPage(){
		
		//driver.get(Constants.URL_Rediff);
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
