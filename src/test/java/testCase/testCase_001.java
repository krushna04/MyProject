package testCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.homePage;
import testBase.testClass;

public class testCase_001 extends testClass{
		
	@Test
	public void testCase() {
		
		logger.info("***** testCase_001 *****");
		
		try {
			homePage hp = new homePage(driver);
			hp.getUserName(prop.getProperty("userID"));
			hp.getPassWord(prop.getProperty("password"));
			hp.loginBtn();
			logger.info("***** Login *****");
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, "Swag Labs");
		} catch (Exception e) {
			logger.error("Test Fail");
			logger.debug("Debug log..");
			Assert.fail();
		}
	}
	
}
