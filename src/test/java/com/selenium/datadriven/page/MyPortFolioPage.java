package com.selenium.datadriven.page;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.selenium.datadriven.util.Constants;

public class MyPortFolioPage extends BasePage{
	WebDriver driver;
	@FindBy(xpath="//*[@id='createPortfolio']")
	public WebElement CreatePortFolioLink;
	@FindBy(xpath="//*[@id='create']")
	public WebElement portfolioName;
	@FindBy(xpath="//*[@id='createPortfolioButton']")
	public WebElement createPortfolioBtn;
	
	@FindBy(xpath="//*[@id='addStock']")
	public WebElement addStockLink;
	@FindBy(xpath="//*[@id='addstockname']")
	public WebElement stockCoName;
	@FindBy(xpath="//*[@id='stockPurchaseDate']")
	public WebElement calendar;
	@FindBy(xpath="//*[@id='addstockqty']")
	public WebElement stockQuantity;
	@FindBy(xpath="//*[@id='addstockprice']")
	public WebElement Price;
	@FindBy(xpath="//*[@id='addStockButton']")
	public WebElement addStockBtn;
	@FindBy(xpath="//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button") 
	public WebElement BackArrowBtn;
	@FindBy(xpath="//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")
	public WebElement ForwordArrowBtn;
	@FindBy(xpath="//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")
	public WebElement datePicker;
	
	public WebElement monthYearDisplayed;
	
	@FindBy(xpath=Constants.SELECT_XPATH)
	public WebElement SelectDropdown;
	
	public MyPortFolioPage(WebDriver dr){
		driver = dr;		
	}
	
	public MyPortFolioPage createPortfolio(String PortfilioName){
		CreatePortFolioLink.click();
		portfolioName.clear();
		portfolioName.sendKeys(PortfilioName);
		createPortfolioBtn.click();
		
		MyPortFolioPage portFolio = PageFactory.initElements(driver, MyPortFolioPage.class);
		return portFolio;
		
	}

	public void addStock(String stockName,
				String date,
				String stockQnty,
				String stockPrice){
		addStockLink.click();
		stockCoName.sendKeys(stockName);
		driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[1]")).click();
		//date
		calendar.click();
		
		SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyy");
		
		try{
			Date dateTobeSelected = sf.parse(date);
			Date currentDate = new  Date();
			
			System.out.println(currentDate.compareTo(dateTobeSelected));
			
			sf = new SimpleDateFormat("MMMM");
			String month = sf.format(dateTobeSelected);
			sf = new SimpleDateFormat("dd");
			String day = sf.format(dateTobeSelected);
			System.out.println(day);
			sf = new SimpleDateFormat("yyyy");
			String year = sf.format(dateTobeSelected);
			
			String monthYearTobeSelected = month+" "+year;
			System.out.println(monthYearTobeSelected);
			monthYearDisplayed = driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div"));
			System.out.println(monthYearDisplayed.getText());
			
			while(!monthYearDisplayed.getText().equals(monthYearTobeSelected)){
				if(currentDate.compareTo(dateTobeSelected)==1){
					BackArrowBtn.click();
				}else if(currentDate.compareTo(dateTobeSelected)==-1){
					ForwordArrowBtn.click();
				}
				monthYearDisplayed = driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div"));
			}
			//day
			driver.findElement(By.xpath("//td[text()="+day+"]" )).click();
			
			stockQuantity.sendKeys(stockQnty);
			Price.sendKeys(stockPrice);
			addStockBtn.click();
		}catch (ParseException exp){
			exp.printStackTrace();
		}
	}
	
	public void selectFromDropdown(String nameOfPortfolio){
		//String portfolioName = "Mohammad PortFollio";
		//Select[@id='portfolioid']/option[text()='Mohammad PortFollio']
		SelectDropdown.click();
		WebElement ele = driver.findElement(By.xpath(Constants.SELECT_XPATH));
		Select dropDown = new Select(ele);
		dropDown.selectByVisibleText(nameOfPortfolio);
		
	}
	public boolean isDropdownSelected(String nameOfPortfolio){
		
		List<WebElement> pfolioName = driver.findElements(By.xpath("//Select[@id='portfolioid']/option"));
		
		 for(int i=0; i<pfolioName.size(); i++){
			 String portFolio = pfolioName.get(i).getText();
			 if(portFolio.equals(nameOfPortfolio)){
				 return true;
			 } 
		 }
		 return false;
		
		
	}

}
