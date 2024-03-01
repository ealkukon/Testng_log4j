package util;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Javascriptutilites {
 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        browser("chrome","https://www.ebay.com/");
        
        Thread.sleep(3000);
        
      //  WebElement buy=driver.findElement(By.xpath("(//a[@class='gf-bttl thrd'])[1]"));
        
       // scrollintoview(driver, buy);
        
     //   Thread.sleep(6000);
       // scrolldown(driver);
        
       //flash(buy, driver) ;
        WebElement motor=driver.findElement(By.linkText("Motors"));
        
       // motor.click();
        flash(motor, driver);
        
        
  
	}
	
	
	public static void browser(String browsername, String url ) throws InterruptedException {
		if(browsername.equalsIgnoreCase("chrome")) {

			  System.setProperty("webdriver.chrome.driver","C:\\Ealdatabase\\Eclips\\workspace\\project.selenium\\Driver\\chromedriver.exe") ;
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.get(url);
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			
			  System.setProperty("webdriver.edge.driver","C:\\Ealdatabase\\Eclips\\workspace\\project.selenium\\Driver\\msedgedriver.exe") ;
				driver=new EdgeDriver();
				driver.manage().window().maximize();
				Thread.sleep(2000);
				driver.get(url);
		}

    }
	
	public static void scrollintoview(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].scrollIntoView(true);",element);
		
	}
	public static void scrolldown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	public static void changecolour(String color,WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].style.backgrondColor='"+color+"'", element);
		try {
			 Thread.sleep(2000);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	public static void flash(WebElement element,WebDriver driver) {
		
		 String bgcolor=element.getCssValue("backgroundColor");
		 
		 System.out.println(bgcolor);
		 
		 for(int i=0;i<30;i++) {
			 changecolour("	#FF69B4", element, driver);
			 changecolour(bgcolor, element, driver);
		 }

	

	
	
	
}
	
	public static void draw(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].style.border='3px solid red'",element);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
