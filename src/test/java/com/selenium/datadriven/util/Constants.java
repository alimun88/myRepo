package com.selenium.datadriven.util;

public class Constants {
	public static final String xls_filePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\selenium\\datadriven\\data\\POM_TestCases.xlsx";
	public static final String expected_Title = "BSE: 24,714.96 | NSE: 7,507.45 - Live Stock Market | Share Prices | Mutual Fund India: Rediff MoneyWiz";
			//"Rediff.com: Online Shopping, Rediffmail, Latest India News, Business, Bollywood, Sports, Stock, Live Cricket Score, Money, Movie Reviews";
	                                           //BSE: 24,646.48 | NSE: 7,485.35 - Live Stock Market | Share Prices | Mutual Fund India: Rediff MoneyWiz
	public static String URL_Rediff="http://money.rediff.com/index.html";
	public static String userEmail = "ayon88@hotmail.com";
	public static String Password = "AllyMoon88";
	public static String createProfileName= "Liaquat153";

	public static String logoutLink ="//a[text()='Sign Out']";
	
	//Xls SheetNames
	public static String TESTCASE_SHEET = "Test Cases";
	public static String TESTDATA_SHEET = "Test Data";
	
	// colNames
	public static String TCID_COL = "TCID";
	public static String RUNMODE_COL = "Runmode";
	public static String CONAME_COL= "CompayName";
	public static String PDATE_COL= "PurchaseDate";
	public static String STOCKQTY_COL= "StockQnty";
	public static String STOCKPRICE_COL= "StockPrice";
	
	public static String USENAME_COL = "Username";	
	public static String PASSWORD_COL = "Password";	
	public static String FLAG_COL = "Data_Flag";
	
	public static String PFNAME_COL = "PortFolioName";	
	public static String BROWSERTYPE_COL = "BrowserType";
	//Name of TestCases
	public static String LOGIN_TEST = "LoginTest";
	public static String CREATEPF_TEST = "CreatePortFolioTest";
	public static String INVEST_TEST = "InvestmentTest";
	
	//xpath
	public static final String SELECT_XPATH = "//Select[@id='portfolioid']";
	public static final String _XPATH = "//Select[@id='portfolioid']";
	
	

}
