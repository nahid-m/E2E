package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
      
	
	  public static  Logger log =LogManager.getLogger(Base.class.getName());
	
	
	  @BeforeTest
	  public void initialize() throws IOException{
		  driver = initializeDriver();
		  driver.get(prop.getProperty("url") );
		  log.info("LOG TEST");
	  }

	  @Test(dataProvider="getData")
		public void basePageNavigation(String UserName,String Password,String text) throws IOException, InterruptedException {
			
			
		    driver.get(prop.getProperty("url") );
			LandingPage l = new LandingPage(driver);
			l.getLogin().click();
			LoginPage lp= new LoginPage(driver);
			lp.getEmail().sendKeys( UserName);
			lp.getPassword().sendKeys(Password);
		    System.out.println(text);
			lp.getLogin().click();
			Thread.sleep(5000);
		}


	    @DataProvider
		public Object[][] getData() {
			
			Object[][] data=new Object[2][3];
			
			data[0][0]="nanan@qw.com";
			data[0][1]="123321";
			data[0][2]="Restricted User";
			
			data[1][0]="abc@qw.com";
			data[1][1]="123456";
			data[1][2]="Non Restricted User";
			
			return data;
		}
      @AfterTest
      public void tearDown() {
    	  driver.close();
    	  driver=null;
    	  
      }
  
}
