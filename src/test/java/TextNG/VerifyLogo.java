package TextNG;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLogo {
	 FileReader reader ;
	 WebDriver driver;
	   Properties  prop;
	 
	 @BeforeMethod
	public void setUp() throws IOException {
      reader = new FileReader("Properties\\txt.properties");
     prop = new Properties();
      prop.load(reader);
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    String url = prop.getProperty("url");
    driver.get(url);
     driver.manage().window().maximize();
     
	}
	 
	 @Test
	 public void verifyLogo() {
		 boolean logo =  driver.findElement(By.xpath(prop.getProperty("logo"))).isDisplayed();
		Assert.assertTrue(logo);
	 }
	 
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.close();
	 }
	

}
