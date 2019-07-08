package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class Assignment2 {
	
	public WebDriver driver;
  @Test(priority=1)
  public void ClickonMobile() {
	  driver.findElement(By.xpath("//li[@class='level0 nav-1 first']/child::a")).click();
	 
	  String cost1=driver.findElement(By.xpath("//span[@id='product-price-1']")).getText();
	  System.out.println(cost1);
	  driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();
	  
	  String cost2=driver.findElement(By.xpath("//span[@class='price']")).getText();
	  System.out.println(cost2);
	  Assert.assertEquals(cost1, cost2);
	  System.out.println("Costs Are Matched");
	  
	  
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
