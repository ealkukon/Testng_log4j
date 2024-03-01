package listenerpack;



import org.testng.ITestListener;
import org.testng.ITestResult;

import util.utilitie_1;


public class Listeners  extends util.utilitie_1  implements ITestListener  {

	@Override
	public void onTestSuccess(ITestResult result) {
	this.driver=((utilitie_1)result.getInstance()).driver;
		
			screenshort("Allsuccess");
	    	System.out.println("screenshot taking successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.driver=((utilitie_1)result.getInstance()).driver;
		
			screenshort("Allfailed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	
}
