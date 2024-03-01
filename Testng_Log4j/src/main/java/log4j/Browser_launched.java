package log4j;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_launched {
  public static WebDriver driver;
  
 public static Logger log=LogManager.getLogger(Browser_launched.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		log.info("driver lanched");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.manage().window().maximize();
		log.error("wait is filed");
	
		driver.get("https://www.myntra.com/");
		log.warn("user land on website");
	
		
		try {
			driver.findElement(By.linkText("Women")).isDisplayed();
			driver.findElement(By.linkText("Women")).click();
		} catch (Exception e) {
			log.error("exception is occured",new Exception("element not found"));
			
		}
		
		finally {
			driver.quit();
		}
		
	}

}
