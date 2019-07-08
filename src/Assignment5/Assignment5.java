package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment5 {
	public WebDriver driver;
	
  @Test
  public void accountRegistration() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2]")).click();
	  driver.findElement(By.cssSelector("[id='header-account'] [ title='My Account']")).click();
	  driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
	 
	  //Registration
	  
	  driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("Jaydeep");
	  driver.findElement(By.cssSelector("input[id='middlename']")).sendKeys("Shivaji");
	  driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("Mate");
	  
	  driver.findElement(By.cssSelector("input[class='input-text validate-email required-entry']")).sendKeys("jaydeep04nov.pro@gmail.com");
	  driver.findElement(By.cssSelector("input[class='input-text required-entry validate-password']")).sendKeys("Jsm00007!");
	  driver.findElement(By.cssSelector("input[class='input-text required-entry validate-cpassword']")).sendKeys("Jsm00007!");
	  
	  driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	  
	  driver.findElement(By.cssSelector("button[title='Register']")).click();
	  
	  System.out.println("Expected Account Registration done Successfully");
	  
	  Thread.sleep(3000);
	  
	  //Add WishList
	  
	  driver.findElement(By.cssSelector("[class='nav-primary'] [class='level0 nav-2 last']")).click();
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
	  
	  
	  //Share Wishlist
	  
	  driver.findElement(By.cssSelector("textarea[name='emails']")).sendKeys("jaydeep04nov.pro@gmail.com");
	  driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("I am Sharing this WishList Of TV Model LCD");
	  driver.findElement(By.cssSelector("button[title='Share Wishlist']")).click();
	  
	  String act_msg=driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
	  String exp_msg="Your Wishlist has been shared.";
	  
	  Assert.assertEquals(act_msg, exp_msg);
	  System.out.println(act_msg);
	  
	  

  }
  @BeforeClass
  public void mximizeBrowser() {
	  
	  driver.manage().window().maximize();
	  
  }

  @BeforeTest
  public void enterApplicationUrl() {
	  driver.get("http://live.guru99.com");
  }

  @BeforeSuite
  public void openBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaydeep\\Desktop\\Selenium Testing Material\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }
}
