package nonCommerceGUITest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;

import nonCommerceGUI.HomePageUI;

public class HomePageUITests {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	private ThreadLocal <JSONFileManager> testData = new ThreadLocal<>() ;
	
	@BeforeClass
	public void beforeClass() {
		testData.set(new JSONFileManager("src/test/resources/TestDataFiles/TestJsonFiles/testData.Json"));
	}

	@BeforeMethod
	public void setup() {
		driver.set(DriverFactory.getDriver());
	}

	@Test(description = "Make sure currency selected by default is US dollar")
	public void checkCurrencySelectedByDefault() {
		new HomePageUI(driver).openHomePage();
		Validations.verifyThat().element(driver.get(), new HomePageUI(driver).checkDefaultCurrencySelected()).text()
				.isEqualTo(new HomePageUI(driver).defaultCurrency).perform();
	}

	@Test (description = "search for an item ")
	public void searchForItem() {
		// add JSON path of element we need to search for 
		Validations.verifyThat().element(driver.get(),new HomePageUI(driver).openHomePage().searchForItem(testData.get().getTestData("x.searchData[0]"))).
		exists().withCustomReportMessage("element with id 18 not displayed ").perform();
		
	}
	
	@Test (description = "search for an item ")
	public void searchForItem2() {
		// add JSON path of element we need to search for 
		Validations.verifyThat().element(driver.get(),new HomePageUI(driver).openHomePage().searchForItem(testData.get().getTestData("x.searchData[1]"))).
		exists().withCustomReportMessage("element with id 18 not displayed ").perform();
		
	}

	@AfterMethod
	public void tearDown() {
		BrowserActions.closeCurrentWindow(driver.get());
	}

}
