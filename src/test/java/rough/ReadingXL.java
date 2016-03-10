package rough;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.datadriven.TestBase;
import com.selenium.datadriven.util.Utility;

public class ReadingXL extends TestBase{
	
	@BeforeTest
	public void beforeTest(){
		initXlsReader();
	}
	
	@Test
	public void readxls_Test(){
		//System.out.println(Utility.isTestRunable("LoginTest", xls));
		//System.out.println(Utility.isTestRunable("CreatePortFolioTest", xls));
		//System.out.println(Utility.isTestRunable("InvestmentTest", xls));
		Utility.getData("LoginTest", xls);
		Utility.getData("CreatePortFolioTest", xls);
		Utility.getData("InvestmentTest", xls);
	}

}
