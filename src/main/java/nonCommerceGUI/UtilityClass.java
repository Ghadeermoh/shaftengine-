package nonCommerceGUI;

import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;

public class UtilityClass {

	private ThreadLocal<WebDriver> driver;

	public UtilityClass(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	public void openNonCommerceWebSite() {
		BrowserActions.navigateToURL(driver.get(),("https://demo.nopcommerce.com/"));
	}

}
