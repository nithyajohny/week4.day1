package week4.day1homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {
	/*3.Assignment for WindowHandles  
	Salesforce Customer service:
	1.Launch the browser
	2.Load the url as " https://login.salesforce.com/ "
	3.Enter the username as " ramkumar.ramaiah@testleaf.com "
	4. Enter the password as " Password$123 "
	5.click on the login button
	6.click on the learn more option in the Mobile publisher
	7.Switch to the next window using Windowhandles.
	8.click on the confirm button in the redirecting page
	9.Get the title
	10.Get back to the parent window
	11.close the browser*/
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
			driver.get("https://login.salesforce.com/ ");
	 
	      driver.manage().window().maximize();
	     // manage timeout -> findElement(s)
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
			driver.findElement(By.id("password")).sendKeys("Password$123");
			driver.findElement(By.id("Login")).click();
               driver.findElement(By.xpath("//button[@title='Learn More']")).click();
               Set<String> totalwindowHandles = driver.getWindowHandles();
               System.out.println("total wh"+totalwindowHandles.size());
               
               List<String> abc =new ArrayList<String>(totalwindowHandles);
               String firwh = abc.get(0);
               String secwh = abc.get(1);
               driver.switchTo().window(secwh);
               driver.findElement(By.xpath("//button[text()='Confirm']")).click();
       		System.out.println(driver.getTitle());
       		Thread.sleep(3000);
       		driver.close();
            driver.switchTo().window(firwh); 
            



	}

}
