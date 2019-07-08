package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment3 {
	
	public WebDriver driver;
  @Test(priority=1)
  public void AddtoCart() {
	  
	  driver.findElement(By.xpath("//li[@class='level0 nav-1 first']/child::a")).click();
	  
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	  
	  driver.findElement(By.cssSelector("[class='product-cart-actions'] [data-cart-item-id='MOB001']")).sendKeys("1000");
	  
	  driver.findElement(By.cssSelector("[class='product-cart-actions'] [name='update_cart_action']")).click();
	  
	  String act_error=driver.findElement(By.cssSelector("p[class='item-msg error']")).getText();
	  
	  System.out.println(act_error);
	  String exp_error="The requested quantity of 'Sony Xperia' is not available";	
	  
	  Assert.assertEquals(act_error, exp_error);
	  System.out.println("Error Messege Verified");
	  
	 
  }
  @Test(priority=2)
  public void emptycart()
  {
	  
 driver.findElement(By.cssSelector("button[title='Empty Cart']")).click();
	  
	  String empty_messege1=driver.findElement(By.xpath("//div[@class='cart-empty']/p[1]")).getText();
	  System.out.println(empty_messege1);
	  String empty_messege2="SHOPPING CART IS EMPTY";
	  Assert.assertEquals(empty_messege1, empty_messege2);
	  System.out.println("Cart is Empty : Verified");
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
