package ealtestng_pack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Ex_tent {
	ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("Results/_"+System.currentTimeMillis()+"Spark.html");
	  ExtentTest test;
  @Test
  public void navigatehomepage() {
	  test=extent.createTest("launched brwoser and go to website");
	  //go to url
	  test.info("user succesfully land on homepage");
	  //validatepagetitle
	  test.pass("hompagetitle verified");
	  
  }
  @Test
  public void t2 (){
	  test=extent.createTest("validate login field");
	  //type email and password in login field
	  test.warning("alert displaying");
	  test.pass("user log success");
  }
  @Test
  public void t3() {
	  test=extent.createTest("validate dashboard");
	  //click on dashboard
	  //verify the title
	  test.fail("title is failed");
	  //verify homepage
	  test.skip("test skipped");
	 
  }
  @BeforeTest
  public void beforeTest() {
	  extent.attachReporter(spark);
	  

	  
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
