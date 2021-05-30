package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Advanced_features.Encryption;

public class login {
	
	WebDriver driver ;
	
	public login(WebDriver driver) {
		super();
		this.driver = driver;
		
	}
	@FindBy(name="uname")
	WebElement username;
	
	@FindBy(name="psw")
	WebElement password;
	
	@FindBy(xpath="//button[@class='loginbtn']")
	WebElement login_btn;
			
	
	
	
	public void enter_username(WebDriver driver_instance,String str)
	{
		username.sendKeys(str);
	}
	
	public void enter_password(WebDriver driver_instance,String str)
	{
		password.sendKeys(str);
	}
	
	
	public void loginn(String str1,String str2)
	{
		Encryption en = new Encryption();
		enter_username(driver,str1);
		enter_password(driver,en.decrypt_data(str2));
		login_btn.click();
	}

	
	

}
