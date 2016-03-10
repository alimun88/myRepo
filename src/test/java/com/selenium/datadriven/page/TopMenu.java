package com.selenium.datadriven.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage{
	
	@FindBy(xpath="//*[@id='signin_info']/a")
	public WebElement SignoutLink;	
	
	
	public void signOut(){
		SignoutLink.click();
	
	}

}
