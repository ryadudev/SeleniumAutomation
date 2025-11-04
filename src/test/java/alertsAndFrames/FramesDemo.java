package alertsAndFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Frames : subset of web page which contains elements.
 * iFrame : web page embedded in another web page 
 */

public class FramesDemo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		/*
		 * Without switching the frame, if we try below it will throw exception.
		 * Uncomment and execute to see the exception
		 */
//		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("hellooo");
		
		/*
		 * Switch to frame.
		 * driver.switchTo().frame(id/name/webelement/index)
		 */
		
		//Frame1
		WebElement frame1 =  driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("hellooo");
		
		/*
		 * Once we are done with frame1, driver is still in frame1. We have to come out of frame1
		 * We can't jump from one frame to another.
		 * We have to switch from frame1 to webpage and then jump to frame2....
		 * we do that using method: defaultContent()
		 */
		
		driver.switchTo().defaultContent();
		
		//Frame2
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame2");
		
		driver.switchTo().defaultContent();
		
		//Frame3
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3");
		


		//iFrame/nested frame::part of frame3
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//div[@class='AB7Lab Id5V1'])[1]")).click();
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
