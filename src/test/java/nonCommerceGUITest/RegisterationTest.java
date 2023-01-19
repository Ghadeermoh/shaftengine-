package nonCommerceGUITest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;

import nonCommerceGUI.Registeration;

public class RegisterationTest {
	
	private ThreadLocal <WebDriver> driver = new ThreadLocal<>();
	
	@BeforeClass
	public void setup() {
		driver.set(DriverFactory.getDriver());
		new Registeration(driver).openRegisterationPage();
		new Registeration(driver).readFromExcell();
	}
	
	@Test (description = "Make sure registeration done with correct data ")
	public void testRegisteration() {
		new Registeration(driver).fillRegisterationForm();
		
	}
	

}
