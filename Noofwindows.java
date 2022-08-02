package week4.day1homeassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Noofwindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
			driver.get("http://www.leafground.com/pages/Window.html");
	 
	      driver.manage().window().maximize();
	     // manage timeout -> findElement(s)
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			//click homepage an click buttons get title for this window,
			//return back to parent window and get title,close all windows.
			driver.findElement(By.id("home")).click();
			Set<String> totalwindowHandles = driver.getWindowHandles();
            System.out.println("total wh"+totalwindowHandles.size());
            
            List<String> abc =new ArrayList<String>(totalwindowHandles);
            String firwh = abc.get(0);
            String secwh = abc.get(1);
            driver.switchTo().window(secwh);
            driver.findElement(By.xpath("//img[@alt='Buttons']")).click();
            System.out.println(driver.getTitle());
             driver.close();
             driver.switchTo().window(firwh);
             System.out.println(driver.getTitle());
             //Find the number of opened windows click open multiple window button//switch control to interact with hyperlinks 
             //and click Verify am I broken?,switch control back to main window.
             driver.findElement(By.xpath("//button[@onclick='openWindows()']")).click();
             
             Set<String> totalwindowHandles1 = driver.getWindowHandles();
             System.out.println("total wh"+totalwindowHandles1.size());
             
             List<String> abc1 =new ArrayList<String>(totalwindowHandles1);
             String firwh1 = abc1.get(0);
             String secwh1 = abc1.get(1);
             String thirwh = abc1.get(2);
             driver.switchTo().window(secwh1);
              System.out.println(driver.getTitle());
              driver.manage().window().maximize();
              Thread.sleep(2000);
             driver.findElement(By.linkText("Verify am I broken?")).click();
             driver.close();
             driver.switchTo().window(thirwh);
             System.out.println(driver.getTitle());
             driver.close();
             driver.switchTo().window(firwh1);

             
           
 
			
	}

}
