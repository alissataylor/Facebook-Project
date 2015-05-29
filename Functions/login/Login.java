package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;

	// Setup Object Repository

	@FindBy(id = "email")
	WebElement txtLoginEmail;

	@FindBy(id = "pass")
	WebElement txtPassword;

	@FindBy(id = "u_0_n")
	WebElement btnLogin;

	public Login(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);
	}

	// Setup page functions

	public void LoginFunction() {

		txtLoginEmail.sendKeys("alissa.taylor@orasi.com");
		
		txtPassword.sendKeys("Orasi2");
		
		btnLogin.click();
	}

}
