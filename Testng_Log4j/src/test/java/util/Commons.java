package util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ealtestng_pack.Logtestng;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
	public WebDriver driver;
	String ud= System.getProperty("user.dir");
	public Logger log=LogManager.getLogger(Logtestng.class);
public	ExtentReports extent = new ExtentReports();
public  ExtentSparkReporter spark = new ExtentSparkReporter("Results/jenkins_extentReport.html");
	public  ExtentTest test;
	
	 public  void waitfortitle(String pagetitle,WebDriver driver) {
			
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofHours(1));
		    wait.until(ExpectedConditions.titleContains(pagetitle));
		}
	 
		public  void waitforclickable(WebElement element,WebDriver driver) {
		    WebDriverWait wait=new WebDriverWait(driver,Duration.ofHours(1));
		    wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		public void implicitywait() {
			 WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(30));
		}
		public void teardown() {
			  driver.close();
		  }
		  public  void waitfortitle(String pagetitle) {
			    WebDriverWait wait=new WebDriverWait(driver,Duration.ofHours(1));
			    wait.until(ExpectedConditions.titleContains(pagetitle));
			}
		  public void implicitywait(WebDriver driver) {
				 WebDriverWait waits=new WebDriverWait(driver,Duration.ofSeconds(30));
			}
		  public  void screenshort(String foldername)  {

					
					File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					try {
						FileHandler.copy(ss,new File(ud+"\\pictures\\"+foldername+"\\"+System.currentTimeMillis()+"home.jpg") );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
		  
		  public  String capturessfor(String foldername)  {

				
				File ss= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File destinationpath=new File(ud+"\\pictures\\"+foldername+"\\home"+System.currentTimeMillis()+".jpg");
				try {
					FileHandler.copy(ss,destinationpath );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String absolutepath=destinationpath.getAbsolutePath();
				return absolutepath;
			}
		  
		  public  void browser(String browsername, String url ) throws InterruptedException {
				
				
				
				if(browsername.equalsIgnoreCase("chrome")) {

					  WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
						driver.manage().window().maximize();
						Thread.sleep(2000);
						driver.get(url);
				}
				else if(browsername.equalsIgnoreCase("edge")) {
					
					   WebDriverManager.edgedriver().setup();
						driver=new EdgeDriver();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
						driver.manage().window().maximize();
						Thread.sleep(2000);
						driver.get(url);
				}
		  
    }
		public void configreport() { 
			extent.attachReporter(spark);
			
			extent.setSystemInfo("Machine","Testpc1");
			extent.setSystemInfo("os", "windows");
			extent.setSystemInfo("browser", "chrome");
			extent.setSystemInfo("username","Alam");
			//look change
			
			spark.config().setDocumentTitle("alam report");
			spark.config().setReportName("google test report");
			spark.config().setTheme(Theme.DARK);
			
		}
		  
}
