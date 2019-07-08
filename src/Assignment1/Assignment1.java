package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Assignment1 {
	
	public WebDriver driver ;
	
  @Test(priority=1)
  public void HomeTitle() {
	  String act_Title =driver.getTitle();
	  System.out.println("Actual Title is :-"+act_Title);
	  String exp_Title="THIS IS DEMO SITE";
	  
	  Assert.assertEquals(act_Title, exp_Title);
	  
	 
	  
	  
	  
  }
  @Test(priority=2)
  public void MobileTitle() {
	  driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a")).click();
	  String act_Title =driver.getTitle();
	  System.out.println("Actual Title is :-"+act_Title);
	  String exp_Title="MOBILE";
	  
	  if(act_Title.equalsIgnoreCase(exp_Title))
	  {
		  System.out.println("Titles Matched");
		  
	  }
	  
	  Assert.assertEquals(act_Title, exp_Title);
	  
	 
	  
	  
  }
  
  @Test(priority=3)
	public void sort()
	{
	 
      ArrayList<String> list=new ArrayList<>();
	  WebElement category=driver.findElement(By.cssSelector("div[class='category-products']"));
	  List<WebElement> links=category.findElements(By.tagName("h2"));
	  int count=links.size();
	  System.out.println("Number of Products :"+count);
	  
	  for(WebElement ls:links)
	  {
		  /*System.out.println(ls.getText());*/
		  list.add(ls.getText());
		  
	  }
	 
	 Iterator<String> itr=list.iterator();
	 
	 while(itr.hasNext())
	 {
		 String val=itr.next();
		 /*System.out.println(val);*/
		 
	 }
	  Collections.sort(list);
	  
	  
	  
	  
	  
	  
	  
	  WebElement obj=driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select"));
	  obj.click();
	  Select sel=new Select(obj);
	  sel.selectByVisibleText("Name");
	 
	 
	  
	  ArrayList<String> list1=new ArrayList<>();
	  WebElement category1=driver.findElement(By.cssSelector("div[class='category-products']"));
	  List<WebElement> links1=category1.findElements(By.tagName("h2"));
	  int count1=links1.size();
	  System.out.println("Number of Products :"+count1);
	  
	  for(WebElement ls:links1)
	  {
		  /*System.out.println(ls.getText());*/
		  list1.add(ls.getText());
		  
	  }
	  
	  Assert.assertTrue(list.equals(list1));
	}
	  
	  
	  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void maximizeBrowser() {
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void enterAppliationURL() {
	  driver.get("http://live.guru99.com");
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void openBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaydeep\\Desktop\\Selenium Testing Material\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
