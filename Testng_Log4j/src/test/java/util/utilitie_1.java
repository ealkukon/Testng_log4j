package util;

import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
    
public class utilitie_1  extends Commons{




  @Parameters({"browser","website"})
  @BeforeClass
  public void beforeClass(String browser,String website) throws InterruptedException {
	  log.info("browser launched");
	  browser(browser,website);
  }

  @AfterClass
  public void afterClass() {
	  log.info("browser going to be closed");
	  teardown();
	  
	
  }@BeforeTest
  public void beforeTest() {
	log.info("befort test start");
	  
	  

	  
  }

  @AfterTest
  public void afterTest() {
	log.info("after test start");
  }
  
  
  

  
		
		

}
  

  


