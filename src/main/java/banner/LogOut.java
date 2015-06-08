package banner;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import setup.BaseClass;

/**
 * 
 * @author andy.williams
 * 
 * @Summary The LogOut Class contains functionality to access the Logout button successfully.
 * Included are Web Elements as well as the Methods needed to access Log Out
 * 
 * @Date 06/03/2015
 *
 */

public class LogOut{
	/**
	 * Web Elements Established
	 */
	private BaseClass base = null;
	
	
	@FindBy(id = "pageLoginAnchor")
	WebElement bannerCarat;
	
	@FindBy(className = "uiLinkButtonInput")
	WebElement drpDwnLogout;
	
	@FindBy(xpath = ".//*[@id='login_form']/table/tbody/tr[1]/td[1]/label")
	WebElement lblEmailOrPhone;
	
	/**
	 * Methods Establish
	 */

	
	public LogOut(BaseClass base){
		this.base = base;
		PageFactory.initElements(base.getDriver(), this);
	}
	
	

	public void bannerCaratClicks(){
		bannerCarat.click();
	}
	
	public void Logout(){
		bannerCaratClicks();
		drpDwnLogout.click();
		Assert.assertTrue(lblEmailOrPhone.isDisplayed());
		Reporter.log("User "+base.getUsername()+" successfully logged out.");
	}
}
