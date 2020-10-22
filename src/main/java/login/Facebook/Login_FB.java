package login.Facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_FB {
	WebDriver driver;
	
	@FindBy(id="email")
	WebElement UserField;  // Stored in a keyword 
	
	@FindBy(id="pass")
	WebElement PassWordField;
	
	@FindBy(name="login")
	WebElement LoginButton;
	
	public Login_FB(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	void enterEmail(String ema) {
		UserField.sendKeys(ema);
	
	}
	
	void enterPassword(String pas) {
		PassWordField.sendKeys(pas);
	}
	
	void clikLogin() {
		LoginButton.click();
	}
	

	

}
