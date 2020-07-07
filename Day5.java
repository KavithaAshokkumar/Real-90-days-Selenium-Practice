package Selenium.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Day5 {

	public static void main(String[] args) throws InterruptedException {
		
//1) Go to https://www.zalando.com/
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		 
	    System.setProperty("webdriver.chrome.silentOutput", "true");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications-");
			
			ChromeDriver driver = new ChromeDriver(options);
			
			driver.get("https://www.zalando.com/");
			
			//driver.manage().window().maximize();
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
//2) Get the Alert text and print it 
			
			// Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);
	        
	        Thread.sleep(5000);

//3) Close the Alert box and click on Zalando.uk
	        
	        // Accepting alert		       
	        alert.accept();	
	        
	       // driver.findElementByXPath("//a[@class='nav_link nav_link-pl']").click();
	        
	      //  driver.findElementByLinkText("Zalando.uk").click();
	        
	        driver.findElementByXPath("//a[@class='nav_link nav_link-gb']").click();
	        
//4) Click Women--> Clothing and click Coats 
	        
	        driver.findElementByXPath("//span[text()='Women']").click();	        
	    
	        WebElement clothing = driver.findElementByXPath("//span[text()='Clothing']");  
	        
	        Actions builder = new Actions(driver);
			  
			builder.moveToElement(clothing).perform();
			
			driver.findElementByXPath("//span[text()='Coats']").click();
			
			//Thread.sleep(3000);
		
//5) Choose Material as cotton (100%) and Length as thigh-length
			
			driver.findElementByXPath("//span[@data-label='Material']/following-sibling::span[1]").click();
			
			driver.findElementByXPath("(//li[@role='checkbox'])[4]").click();
			
			driver.findElementByXPath("//button[text()='Save']").click();
			
			 Thread.sleep(2000);

//6) Click on JUNAROSE - by VERO MODA
			 
			 driver.findElementByXPath("//img[@alt='Classic coat - black washed']").click();
			
			//driver.findElementByXPath("//div[text()='JUNAROSE - by VERO MODA']").click();
			
//7) Click Color as Black and Size as 'M' Under Manufacture Sizes
			
			driver.findElementById("picker-trigger").click();
			
			driver.findElementByXPath("(//li[@role='option']//div)[1]").click();
			
			driver.findElementByXPath("//label[@for='manufacturer']").click();
			
			driver.findElementByXPath("(//li[@role='option']//div)[1]").click();
			
//8) Add to bag only if Standard Delivery is free
			
			String free = driver.findElementByXPath("(//span[text()='Free'])[1]").getText();
			
			System.out.println(free);
			
			if(free.equals("Free"))
			{
				driver.findElementByXPath("//span[text()='Add to bag']").click();
			}

//9) Mouse over on Your Bag and Click on "Go to Bag"
			
			WebElement yourBag = driver.findElementByXPath("//span[text()='Your bag']");	
			
		        Actions builder1 = new Actions(driver);
				  
				builder1.moveToElement(yourBag).perform();
				
				driver.findElementByXPath("//div[text()='Go to bag']").click();

//10) Read the Estimated Deliver Date and print
			
				String deliveryDate = driver.findElementByXPath("//span[text()='Th, 09.07. - Mo, 13.07.']").getText();
				
				System.out.println(deliveryDate);
				
//11) Click on 'Go To Checkout'
				
				driver.findElementByXPath("(//div[text()='Go to checkout'])[1]").click();
				
//12) Enter your email
				
				driver.findElementById("login.email").sendKeys("kavithaashokumar@gmail.com");
				
//13) Click on Login button
				
				driver.findElementByXPath("//span[text()='Login']").click();
				
//14) Print the error message
				
				String errorMessageValidation = driver.findElementByXPath("//span[text()='This field is required']").getText();
	
				System.out.println(errorMessageValidation);
				
				
	}

}
