package nonCommerceGUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;

public class Registeration {

	private ThreadLocal<WebDriver> driver;

	public Registeration(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
	}

	// ---locators -------
	By registerPage = By.cssSelector("a.ico-register");
	By genderFemale = By.id("gender-female");
	By genderMale = By.id("gender-male");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By dateOfBirthDay = By.name("DateOfBirthDay");
	By dateOfBirthMonth = By.name("DateOfBirthMonth");
	By dateOfBirthYear = By.name("DateOfBirthYear");
	By email = By.id("Email");
	By companyName = By.id("Company");
	By newsLetter = By.id("Newsletter");
	By password = By.id("Password");
	By confirmPassword = By.id("ConfirmPassword");
	By registerButton = By.id("register-button");

	ExcelFileManager excelFileTestDataReader;

	public void openRegisterationPage() {
		ElementActions.click(driver.get(), registerPage);
	}

	public void readFromExcell() {
		excelFileTestDataReader = new ExcelFileManager(System.
				getProperty("testDataFolderPath") + "registerdata.xlsx");

	}

	public void fillRegisterationForm() {
		ElementActions.type(driver.get(), email, excelFileTestDataReader.getCellData("FirstName"));

	}

}
