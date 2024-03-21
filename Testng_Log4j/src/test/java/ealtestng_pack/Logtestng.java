package ealtestng_pack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.utilitie_1;

public class Logtestng extends utilitie_1 {

  @Test
  public void verify_homepage() throws InterruptedException {
	  test=extent.createTest("launched brwoser and go to website").assignAuthor("alam").assignCategory("smoke").assignDevice("windows");
	  String expetedtitle="google";
	     log.info("getting title");
	 String actualtitle=  driver.getTitle();
	 log.info("title is collected");
	 if (actualtitle.equalsIgnoreCase(expetedtitle)) {
		log.info("title is matched");
		test.log(Status.PASS,MarkupHelper.createLabel("verify homepage",ExtentColor.GREEN));
		test.addScreenCaptureFromBase64String(capturessfor("sucess"));
	 }
	 else {
		 log.info("title verifyed is failed","expected = "+expetedtitle+"but found ="+actualtitle);
		 test.log(Status.FAIL,MarkupHelper.createLabel("verify homepage failed",ExtentColor.RED));
         test.addScreenCaptureFromPath(capturessfor("failed"),"verify hompage failed");
	 }
	 System.out.println("this is kukon");
	 
	
	  
  }
  @Test
  public void login() throws InterruptedException {
	  test=extent.createTest("login").assignAuthor("faruk").assignCategory("sanity").assignDevice("mac");
	  log.info("start for login");
	  
	  
      }
  @Test
  public void t2() {
	  log.info("test t2");
	  
  }
  
  }
  
  
  

