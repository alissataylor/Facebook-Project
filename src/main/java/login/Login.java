package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.BaseClass;

public class Login {

	private BaseClass base = null;

	// Setup Object Repository

	@FindBy(id = "email")
	WebElement txtLoginEmail;

	@FindBy(id = "pass")
	WebElement txtPassword;

	@FindBy(id = "u_0_n")
	WebElement btnLogin;

	public Login(BaseClass base) {

		this.base = base;

		// This initElements method will create all WebElements

		PageFactory.initElements(base.getDriver(), this);
	}
	
	

	// Setup page functions

	public void LoginFunction() {

		txtLoginEmail.sendKeys(base.getUsername());
		
		txtPassword.sendKeys(base.getPassword());
		
		btnLogin.click();
	}

}
