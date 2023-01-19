package nonCommerceGUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageUI {

	private ThreadLocal<WebDriver> driver;

	public HomePageUI(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}
	
	//----Locators----
	private By customerCurrencyBox= By.xpath("//select[@id='customerCurrency']//option[1]");
	
	public String defaultCurrency="US Dollar";
	
	public By checkDefaultCurrencySelected() {
		
		return  customerCurrencyBox;
	}

}
