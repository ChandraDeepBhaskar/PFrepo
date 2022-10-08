package pfPack.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.pages.LaunchPage;
import pfPack.tests.base.BaseTest;
import pfPack.util.Constants;

public class LoginTest extends BaseTest {
	
	@Test
	public void testLogin() {
		
		//for having logs we need Extent Report
		 eTest = eReport.startTest("LoginTest");
		 
		 eTest.log(LogStatus.INFO,"Login Test has started");
		 
		 openBrowser(Constants.BROWSER_TYPE);
		 
		 //for passing the same driver from BaseTest.java to LaunchPage.java
		 //we need to create object for LaunchPage.java.. for calling it from other package
		 //and import the pack of that java file
		 LaunchPage launchPage = new LaunchPage(driver,eTest);//passing driver and eTest to this LaunchPage from BaseTest.java(parent class of LoginTest)
		 PageFactory.initElements(driver,launchPage);//initElements means initializing elements in launchPage
		 
		 boolean loginStatus = launchPage.goToLoginPage();
		 
		 if(loginStatus) {
			 
			reportPass("Login test passed");
			 
		 }else {
			 
			 reportFail("Login Test failed");
			 
		 }
		 
	}
	
	@AfterMethod
	public void testClosure() {
		
		if(eReport!=null) {
			
			eReport.endTest(eTest);
			eReport.flush();
			
		}
		
		if(driver!=null) {
			
			driver.quit();
			
		}
		
		
	}
	

}
