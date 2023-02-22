package nonCommerceGUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class HomePageUI {

	private ThreadLocal<WebDriver> driver;

	public HomePageUI(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}
	
	//----Locators----
	private By customerCurrencyBox= By.id("customerCurrency");
	private By searchBox = By.id("small-searchterms");
	private By searchButton =By.xpath("//button[@type='submit']");
	private By elementBox = By.xpath("//div[@data-productid='18']");
	
	
	public String defaultCurrency="US Dollar";
	
	public HomePageUI openHomePage() {
			BrowserActions.navigateToURL(driver.get(),(System.getProperty("url")));
			return this;
	}
	
	public By checkDefaultCurrencySelected() {
		
		return  customerCurrencyBox;
	}
	
	public By searchForItem (String itme) {
		ElementActions.type(driver.get(), searchBox, itme);
		ElementActions.click(driver.get(), searchButton);
		return elementBox ;
	}

}
