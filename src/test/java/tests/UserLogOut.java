package tests;

import login.Login;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import banner.LogOut;
import setup.BaseClass;

public class UserLogOut extends BaseClass {
	
	@Test
	@Parameters({ "browser"})
	public void UserLogOutTest(String browser) {
		setBrowser(browser);
		
		String testName = new Object() {
		}.getClass().getName();
		testStart(testName);

		Setup();
		
		Login login = new Login(this);
		login.LoginFunction();
		
		LogOut objLogout = new LogOut(this);
		objLogout.Logout();

	}
	@AfterMethod
	public void closeBrowser(ITestResult result) {
		result.getMethod().getMethodName();
		endTest(testName);
		getDriver().getCurrentUrl();
		getDriver().quit(); // Close browser before each new test
	}
}

