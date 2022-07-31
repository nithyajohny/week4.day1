package week4.day1homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontact {
	/*
	 * //Pseudo Code
	 * 
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 
	 * 2. Enter UserName and Password Using Id Locator
	 * 
	 * 3. Click on Login Button using Class Locator
	 * 
	 * 4. Click on CRM/SFA Link
	 * 
	 * 5. Click on contacts Button
	 * 	
	 * 6. Click on Merge Contacts using Xpath Locator
	 * 
	 * 7. Click on Widget of From Contact
	 * 
	 * 8. Click on First Resulting Contact
	 * 
	 * 9. Click on Widget of To Contact
	 * 
	 * 10. Click on Second Resulting Contact
	 * 
	 * 11. Click on Merge button using Xpath Locator
	 * 
	 * 12. Accept the Alert
	 * 
	 * 13. Verify the title of the page
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get(" http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		// manage timeout -> findElement(s)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("((//span[@class='requiredField'])/following::img)[1]")).click();
		 Set<String> totalwindowHandles = driver.getWindowHandles();
	      System.out.println("total wh"+totalwindowHandles.size());
	      
	      List<String> lst =new ArrayList<String>(totalwindowHandles);
	      String firwh = lst.get(0);
	      String secwh = lst.get(1);
	      Thread.sleep(2000);
	      driver.switchTo().window(secwh);
			driver.findElement(By.linkText("abc")).click(); 
						 // driver.close();	      
			  driver.switchTo().window(firwh);
			  
			driver.findElement(By.xpath("((//span[@class='requiredField'])/following::img)[2]")).click();
			Set<String> totalwindowHandles1 = driver.getWindowHandles();
		      System.out.println("total wh"+totalwindowHandles1.size());
		      
		      List<String> lst1 =new ArrayList<String>(totalwindowHandles1);
		      String thrdwh = lst1.get(0);
		      String fourwh = lst1.get(1);
			 driver.switchTo().window(fourwh);
			 driver.findElement(By.linkText("efg")).click();
			  //driver.close();
			  driver.switchTo().window(thrdwh);

	      driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	      Alert alert=driver.switchTo().alert();
	      //String text=alert.getText();
	      //System.out.println(text);
	      //click ok
	      alert.accept();
	      Thread.sleep(5000);
	      //to check wheather you clicked ok
	    
		System.out.println(driver.getTitle());

	}

}
