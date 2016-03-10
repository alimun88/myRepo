package com.selenium.datadriven.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	TopMenu menu;
	public BasePage(){
		
	}
	 public BasePage(WebDriver dr){
		 driver = dr;
		 menu = PageFactory.initElements(dr, TopMenu.class);
	 }
	 
	 public boolean verifyTitle(String ExpectedTitle){
		 
		 	System.out.println(ExpectedTitle);
			 String actualTitle = driver.getTitle();
			 if (actualTitle.equals(ExpectedTitle)){
				 return true;
			 }else{
				 return false;
			 }
	 }
	 
	 public TopMenu getMenu(){
		 return menu;
	 }
	 
	 public boolean isElementPresent(String xpathExp){
		 int count = driver.findElements(By.xpath(xpathExp)).size();
		 
		 if(count> 0){
			 return true;
		 }else{
			return false;
		 }
	 }
	 

}
