package nonCommerceGUITest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.validation.Validations;

import nonCommerceGUI.HomePageUI;
import nonCommerceGUI.UtilityClass;

public class HomePageUITests {

	private ThreadLocal<WebDriver> driver=new ThreadLocal<>();

	@BeforeClass
	public void setup() {
		driver.set(DriverFactory.getDriver());
		new UtilityClass(driver).openNonCommerceWebSite();
	}

	@Test(description = "Make sure currency selected by default is US dollar")
	public void checkCurrencySelectedByDefault(){
		Validations.verifyThat().element(driver.get(), new HomePageUI(driver).checkDefaultCurrencySelected()).text()
				.isEqualTo(new HomePageUI(driver).defaultCurrency).perform();
	}

}
