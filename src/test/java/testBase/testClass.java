package testBase;

import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class testClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeTest
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		switch (br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default:System.out.println("Invalid browser name");return;
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
