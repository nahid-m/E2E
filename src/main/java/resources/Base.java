 package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
       
	public static WebDriver driver;
	public Properties prop;
	
	
public WebDriver initializeDriver() throws IOException {
		
		
prop= new Properties();
FileInputStream fis= new FileInputStream("C:\\Users\\nahid\\E2E2Project\\src\\main\\java\\resources\\data.properties");

prop.load(fis);
String browserName=prop.getProperty("browser");

if (browserName.equals("chrome")){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nahid\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 driver = new ChromeDriver ();  
}
else if (browserName.equals("firefox")) {
	
}
else if (browserName.equals("IE")) {
	
}

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
return driver;

	}


public void getScreenshot() {
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	//FileUtils.copyFile(src, new File());
	
}




}
