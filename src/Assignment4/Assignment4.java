package Assignment4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment4 {
	
	public WebDriver driver;
  @Test
  public void compare() throws IOException, InterruptedException {
	  
	  driver.findElement(By.xpath("//li[@class='level0 nav-1 first']/child::a")).click();
	  
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  
	  driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  
	  driver.findElement(By.cssSelector("button[title='Compare']")).click();
	  
	  String MainWindow=driver.getWindowHandle();
		System.out.println("Window Key :"+MainWindow);
		
		 Set<String> s1=driver.getWindowHandles();		
	     Iterator<String> i1=s1.iterator();		
	     		
	     while(i1.hasNext())			
	     {		
	         String ChildWindow=i1.next();		
	         		
	         if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	         {    		
	              
	              
	                driver.switchTo().window(ChildWindow);
	                driver.manage().window().maximize();
	                String act_heading=driver.findElement(By.xpath("//div[@class='page-title title-buttons']/h1 ")).getText();
	                String exp_heading="COMPARE PRODUCTS";
	                
	                Assert.assertEquals(act_heading, exp_heading);
	                File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	                FileUtils.copyFileToDirectory(src, new File("C:\\Users\\jaydeep\\Desktop\\Jaydeep Mate\\Selenium Assignments Guru99\\ScreenShots\\"));
	                 
	                Thread.sleep(5000);
	                System.out.println("ScreenShot Taken Successfully");
	                driver.findElement(By.cssSelector("button[title='Close Window']")).click();
		            System.out.println("PopUp Window Closed Successfully");
		           
		
		
	         }
	     }
	  
	  
	  
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
