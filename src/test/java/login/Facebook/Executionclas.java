package login.Facebook;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Executionclas {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String ema, String pas) throws InterruptedException {
	  
	  Login_FB obj = new Login_FB(driver); 
	  obj.enterEmail(ema);
	  Thread.sleep(3000);
	  obj.enterPassword(pas);
	  Thread.sleep(3000);
	  obj.clikLogin();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver Latest/chromedriver.exe");
	   driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "xyz", "456" },
    
    };
  }

}
