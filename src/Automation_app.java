import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Automation_app {
	
	@Test
	public void  function() throws InterruptedException{
		Map<String, String> map = new HashMap<String, String>();
		map.put("Jan", "January");
		map.put("Feb", "Fabruary");
		map.put("Mar", "March");
		map.put("Apr", "April");
		map.put("May", "May");
		map.put("Jun", "June");
		map.put("Jul", "July");
		map.put("Aug", "August");
		map.put("Sep", "September");
		map.put("Oct", "October");
		map.put("Nov", "November");
		map.put("Dec", "December");
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd");
		SimpleDateFormat sd1 = new SimpleDateFormat("dd");
		SimpleDateFormat sd2 = new SimpleDateFormat("MMM");
		
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d);
	    cal.add(Calendar.DATE, 15); //minus number would decrement the days
	    System.out.println(sd.format(cal.getTime()));
		int date = Integer.parseInt(sd1.format(cal.getTime())); 
		String d1 = date+"";
		String mon = sd2.format(cal.getTime());
		//System.out.println(map.get(mon));
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ashiyana\\Downloads\\Compressed\\Jar\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/flights");
		Thread.sleep(5000);
		driver.findElement(By.id("one_way_button1")).click();
		driver.findElement(By.id("from_typeahead1")).clear();
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("document.getElementById('from_typeahead1').value = 'Ahmedabad, India (AMD)';");
		
		driver.findElement(By.id("from_typeahead1")).sendKeys("Ahmedabad, India (AMD)");
		driver.findElement(By.id("from_typeahead1")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("from_typeahead1")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("to_typeahead1")).sendKeys("Pune");
		driver.findElement(By.id("to_typeahead1")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("to_typeahead1")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("start_date_sec")).click();
		
		//String str = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div/span[1]")).getText().toString() ;
		//System.out.println(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div/span[1]")).getText().toString());
		while (true){
			String str = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[2]/div/div/span[1]")).getText().toString() ;
			if(str.equals(map.get(mon))){
				break;	
			}
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[3]/div/a/span")).click();			
		}
		
		int Row_count = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr")).size();
		int Col_count = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td")).size();
		//List<WebElement> allFormChildElements = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody"));
		
		String first_part = "//div[@id='ui-datepicker-div']/div[2]/table/tbody/tr[";
		 String second_part = "]/td[";
		 String third_part = "]";
		 //Used for loop for number of rows.
		 for (int i=1; i<=Row_count; i++){
		  //Used for loop for number of columns.
		  for(int j=1; j<=Col_count; j++){
		   //Prepared final xpath of specific cell as per values of i and j.
		   String final_xpath = first_part+i+second_part+j+third_part;
		   //Will retrieve value from located cell and print It.
		   String Table_data = driver.findElement(By.xpath(final_xpath)).getText();
		  // System.out.print(Table_data +"  ");   
		   if(Table_data.toString().equals(d1)){
			   driver.findElement(By.xpath(final_xpath)).click();
			   }
		   }
		  }		
		//System.out.println(driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div/span[1]")).getText().toString());
		//driver.findElement(By.xpath("/html/body/div[9]/div[2]/table/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("//div[@id='child_count']/a[2]")).click();
		driver.findElement(By.xpath("//div[@id='child_count']/a[2]")).click();
		driver.findElement(By.id("flights_submit")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("duration")).click();
		Thread.sleep(2000);
		System.out.println("Company : "+driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[1]/span[1]/span[2]/span[1]")).getText().toString());
		System.out.println("Duration : "+driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[5]/span[1]")).getText().toString());
		System.out.println("Price :"+driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[3]/div[2]/div[5]/div[1]/div[1]/div[6]/p[1]")).getText().toString());
		Thread.sleep(20000);
		driver.quit();	
	}

	private List<WebElement> findElements(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

}
