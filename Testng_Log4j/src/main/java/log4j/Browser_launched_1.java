package log4j;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_launched_1 {
  public static    WebDriver driver;
  
 public static Logger log=LogManager.getLogger(Browser_launched_1.class);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	 log.info("execution being start");
     WebDriverManager.chromedriver().setup();
     log.info("driver is launched");
     System.out.println();
     driver=new ChromeDriver();
     log.info("calling chrome browser");

     
     driver.manage().window().maximize();
      log.warn("browser maximize");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     
     driver.get("https://www.myntra.com/");
     log.error("url failed");
     

    
    try {
        driver.findElement(By.linkText("Women1")).isDisplayed();
        driver.findElement(By.linkText("Women")).click();
        log.info("women is clicked");
	} catch (Exception e) {
		  log.error("exception is found",new Exception("element not found"));
	}
		
		finally {
			Thread.sleep(3000);
			driver.quit();
		}
	}

}
