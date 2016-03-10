package com.selenium.datadriven.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.datadriven.util.Constants;
import com.selenium.datadriven.util.ErrorUtil;

public class LoginPage extends BasePage{
	
	@FindBy(xpath="//*[@id='wrapper']/div[2]/ul/li[2]/a")
	public WebElement PortfolioLink;
	@FindBy(xpath="//*[@id='useremail']")
	public WebElement emailInput;
	@FindBy(xpath="//*[@id='emailsubmit']")
	public WebElement emailSubmit;
	@FindBy(xpath="//*[@id='userpass']")
	public WebElement passwordInput;
	@FindBy(xpath="//*[@id='loginsubmit']")
	public WebElement loginSubmit;
	
	
	public LoginPage(WebDriver dr){
		super(dr);
	}
	
	public Object doLogin(String userEmail, String passWord) throws InterruptedException{
		
		//verify title
		
		try{
			boolean result = verifyTitle(Constants.expected_Title);
			Assert.assertTrue(result, "Title doesn't match");
		}catch (Throwable exp){
			//report error
			ErrorUtil.addVerificationFailure(exp);
			//capture snapshot
		}
		
		PortfolioLink.click();
		Thread.sleep(2000);
		emailInput.sendKeys(userEmail);
		Thread.sleep(3000);
		emailSubmit.click();	
		//register Page
		passwordInput.sendKeys(passWord);
		loginSubmit.click();	
		//LoginPage
		boolean res = isElementPresent("//*[@id='renamePortfolio']");
		//System.out.println(res);
		if (res)
			//MyPortFolioPage
			return PageFactory.initElements(driver, MyPortFolioPage.class);
		else
			return PageFactory.initElements(driver, LoginPage.class);
	
		}		
	}
	
