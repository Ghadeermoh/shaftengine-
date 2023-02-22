package nonCommerceGUITest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;

import nonCommerceGUI.HomePageUI;
import nonCommerceGUI.Registeration;

public class RegisterationTest {
	
	private ThreadLocal <WebDriver> driver = new ThreadLocal<>();

	
	@BeforeMethod()
	public void openRegisteration() {
		driver.set(DriverFactory.getDriver());
		new HomePageUI(driver).openHomePage();
		new Registeration(driver).openRegisterationPage();
		new Registeration(driver).readFromExcell();
	}
	
	@Test (description = "Make sure registeration done with correct data ")
	public void testRegisteration() {
		new Registeration(driver).fillRegisterationForm();
		
	}
	
	@AfterMethod
	public void tearDown() {
	BrowserActions.closeCurrentWindow(driver.get());
	}

}
