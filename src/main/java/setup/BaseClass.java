package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
 


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
 

 
 
/*
*  @author Andy Williams
*  @summary 
 *  @date 06/01/2015
*                             This class is designed to be extended by page classes and
*          implemented by test classes. It houses test environment data and
*          associated getters and setters, setup for both local and remote
*          WebDrivers as well as page class methods used to sync page behavior.
*         
 */
public class BaseClass {
	

                
                private String browser;
                private String getURL;
                private String strUsername; 
                private String strPassword; 
                protected String testName="";
                final ResourceBundle userCredentialRepo = ResourceBundle.getBundle("config");      
                /*
     * WebDriver Fields
     */
    protected WebDriver driver; /*
                                                                * Define a collection of WebDrivers and test
                                                                * names inside a Map. This allows for more than
                                                            * one driver to be used within a test class.
                                                                * This also allows for a particular driver to
                                                                * be tied to a specific test based on test
                                                                * name.
                                                                */
    protected Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
    
   
                
                
                
                public WebDriver getDriver(){
                                return driver;
                }
                
                public void setDriver(WebDriver driverSession){
                                driver = driverSession;
                }
                
                public String getBrowser() {
                                return browser;
                }
                public void setBrowser(String browser) {
                                this.browser = browser;
                }
                public String getURL() {
                                return getURL;
                }
                public void setURL(String getURL) {
                                this.getURL = getURL;
                }
                public String getUsername() {
                                return strUsername;
                }
                public void setUsername(String strUsername) {
                                this.strUsername = strUsername;
                }
                public String getPassword() {
                                return strPassword;
                }
                public void setPassword(String strPassword) {
                                this.strPassword = strPassword;
                }
                
            	
                private void setProperties(){
                              
                                getURL = userCredentialRepo.getString("URL");
                                strUsername = userCredentialRepo.getString("Username");
                                strPassword = userCredentialRepo.getString("Password");
                }                
                
                public void Setup() {
                                setProperties();
                                File file = null;
                                if (browser.equalsIgnoreCase("firefox")) { // Compares this String to
                                                // another String, ignoring case considerations. Two
                                                // strings are considered equal ignoring case if
                                                // they are of the same length and corresponding characters in the
                                                // two strings are equal ignoring case.
                                                driver = new FirefoxDriver(); // Construct a new object and store a
                                                // reference to it in the variable.
 
                                }
 
                                else if (browser.equalsIgnoreCase("chrome")) { // Compares this String
                                                // to another String, ignoring case considerations. Two
                                                // strings are considered equal ignoring case if they are of the
                                                // same length and corresponding characters in the two strings are
                                                // equal ignoring case.
                                	file = new File(this.getClass().getResource("/drivers/chromedriver.exe").getPath());
                    				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                    							// Set
                                                // to
                                                // specified
                                                // Browser
                                                driver = new ChromeDriver(); // Construct a new object and store a
                                                // reference to it in the variable.
                                }
 
                                else if (browser.equalsIgnoreCase("InternetExplorer")) {
                                                // Compares this String to another String, ignoring case
                                                // considerations. Two strings are considered equal
                                                // ignoring case if they are of the same length and
                                                // corresponding characters in the two strings are equal ignoring
                                                // case.
                                				file = new File(this.getClass().getResource("/drivers/IEDriverServer.exe").getPath());
                                				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                                				// Set
                                                // to
                                                // specified
                                                // Browser
                                                driver = new InternetExplorerDriver(); // Construct a new object and
                                                // store a reference to it
                                                // in the variable.
 
                                }
                                
                                
                                
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set
                                                                                                                                                                                                                                                                                                                // Specified
                                                                                                                                                                                                                                                                                                                // Time
                                                                                                                                                                                                                                                                                                                // Before
                                                                                                                                                                                                                                                                                                                // Timeout
 
                                driver.get(getURL); // Call desired parameter to initiate the URL
                                // Selection
                                driver.manage().window().maximize(); // Maximize WebDriver window
                                
                         
                      
                
                }
                
             

                
                  /**
     * Initializes the WebDriver, sets up the run location, driver type,
     * launches the application.
     * @param testName - Name of the test
     * @version 06/01/2015
     * @author Andy Williams
     */
    protected void testStart(String testName)  {
                
                drivers.put(testName, driver);
                setDriver(drivers.get(testName));
    }
    
    protected void endTest(String testName){
                WebDriver driver = drivers.get(testName);
                if (driver != null && driver.getWindowHandles().size() > 0) {
                                driver.quit();
                }
        }
 
 
}
