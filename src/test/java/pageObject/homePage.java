package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{

	public homePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id=\"user-name\"]")
	WebElement txtuser_name;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement txtpass_word;
	
	@FindBy(xpath = "//input[@id=\"login-button\"]")
	WebElement btnlogin;
	
	public void getUserName(String name) {
		txtuser_name.sendKeys(name);
	}
	
	public void getPassWord(String name) {
		txtpass_word.sendKeys(name);
	}
	
	public void loginBtn() {
		btnlogin.click();
	}
}
