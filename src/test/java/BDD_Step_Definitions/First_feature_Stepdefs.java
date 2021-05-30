package BDD_Step_Definitions;


import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Advanced_features.Apache_poi;
import Advanced_features.DatabaseUtils;
import Advanced_features.Encryption;
import Advanced_features.Mail;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class First_feature_Stepdefs {
	
	WebDriver driver;
	public Scenario myscenario;
	
	@BeforeStep
	public void do_Nothing(Scenario sc) {
		myscenario=sc;
		
	}
	 
	@Before
	public void load_Browser(Scenario sc)
	{
		this.myscenario=sc;
		 WebDriverManager.chromedriver().driverVersion("90.0.4430.85").setup();
		    driver = new ChromeDriver();
		   String a= sc.getName();
		 Status b=   sc.getStatus();
		    System.out.println("name of the scenario is "+ a);
		    System.out.println("status is "+ b.toString());
		    
		    
	
	}
	
	
	@Given("User launches the app")
	public void user_launches_the_app() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		this.myscenario=myscenario;
	    System.out.println("User launches the app");
	   
	    driver.get("http://192.168.1.101:8080");
	    Thread.sleep(4000);
	    TakesScreenshot ts = (TakesScreenshot) driver;
	   byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
	   myscenario.embed(screenshot, "image/png",myscenario.getName());
	   myscenario.write("Sucess Login!!!");
	   
	  
	}
	@When("User in encryption gives {string} as Username and {string} as password" )
	public void user_will_give_right_as_Username_and_as_password(String uname ,String pass) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("User gives right credentials");
		  driver.findElement(By.name("uname")).sendKeys(uname);
		  driver.findElement(By.name("psw")).sendKeys(Encryption.decrypt_data(pass));
          driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
          Thread.sleep(4000);
        }
	
	
	@When ("^User gives credentials through excel$")
	public void Login_with_excel() throws InterruptedException
	{
		List<String> excel_cred=null;
		excel_cred=Apache_poi.Read();
		 System.out.println("User gives right credentials");
		  driver.findElement(By.name("uname")).sendKeys(excel_cred.get(2));
		  driver.findElement(By.name("psw")).sendKeys(Encryption.decrypt_data(excel_cred.get(3)));
         driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
         Thread.sleep(4000);
	}
	

	//\"([^\"]*)\"
	@When("User gives right {string} as Username and {string} as password" )
	public void user_gives_right_credentials(String uname ,String pass) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("User gives right credentials");
		  driver.findElement(By.name("uname")).sendKeys(uname);
		  driver.findElement(By.name("psw")).sendKeys(pass);
          driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
          Thread.sleep(4000);
        }
	
	/*@When("User gives right  Username and password")
	public void user_gives_right_credentials(DataTable data) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		List<String> testdata = data.asList();
		for(String a : testdata)
		{
			System.out.println(a);
		}
		  System.out.println("User gives right credentials");
		  driver.findElement(By.name("uname")).sendKeys(testdata.get(0));
		  driver.findElement(By.name("psw")).sendKeys(testdata.get(1));
          driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
          Thread.sleep(4000);
	}*/
	
	@When("^User gives credentials using database$")
	public void Getdata_from_DB_Login() throws SQLException, InterruptedException
	{
		List<String> DB_cred=null;
		DB_cred=DatabaseUtils.Get_data();
		
		 System.out.println("User gives right credentials using database");
		  driver.findElement(By.name("uname")).sendKeys(DB_cred.get(0));
		  driver.findElement(By.name("psw")).sendKeys(DB_cred.get(1));
         driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
         Thread.sleep(4000);
	}
    	  

	@Then("User should see success message")
	public void user_should_see_success_message() {
	    // Write code here that turns the phrase above into concrete actions
		  System.out.println("User should see success message");
	}

	/*@Given("User launches the browser")
	public void user_launches_the_browser() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User launches the app");
		 System.out.println("User gives right credentials");
		 driver.get("http://192.168.1.101:1080");
	
         Thread.sleep(4000);

   	  
	}*/

	@When("User gives invalid credentials {string} as username and {string} as password")
	public void User_gives_invalid_credentials_as_username_and_as_password(String str,String str1) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User gives invalid credentials");
		  driver.findElement(By.name("uname")).sendKeys(str);
		  driver.findElement(By.name("psw")).sendKeys(str1);
         driver.findElement(By.xpath("//button[@class='loginbtn']")).click();
	}

	@Then("User should see Error message")
	public void user_should_see_Error_message() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User should see Error message");

         Thread.sleep(4000);
	     String error = driver.switchTo().alert().getText();
	     System.out.println(error);
	     driver.switchTo().alert().accept();
	}

   @After
   public void exit_scenario(Scenario sc)
   
   {
	  boolean b= sc.isFailed();
	  if(b)
	  {
		  System.out.println("Oops Scenario"+sc.getName()+"has been failed!!");
	  }
	  else
	  {
		  System.out.println("Scenario "+sc.getName()+" has been Passed!!");
		  Mail.Sendmail("chaitalirajput45@gmail.com","chaitali@7040","chaitalirajput45@gmail.com",
					"My 1st Automation email!!", 
					"test-output\\Spark\\ExtentSpark.html");
	  }
	   driver.close();
	    driver.quit();
   }

}
