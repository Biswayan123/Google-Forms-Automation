package com.qa.forms;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutomteGoogleForms {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://data.bls.gov/timeseries/CEU3133641108?data_tool=Xgtable");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='download_xlsx0']")));
		driver.findElement(By.xpath("//input[@id='download_xlsx0']")).click();

		
		for(int i=1;i<=5;i++) {
			
			System.out.println("Form Filling :" + i);
			
			WebElement radioOption3 = driver.findElement(By.xpath("//div[@id='i11']"));
			WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
			WebElement checkboxOption2 = driver.findElement(By.xpath("//div[@id='i29']"));
			WebElement checkboxOption4 = driver.findElement(By.xpath("//div[@id='i35']"));
			WebElement submitBtn = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
		
			radioOption3.click();
			
			//Thread.sleep(2000);
			textbox.sendKeys("Biswayan");
			
			//Thread.sleep(2000);
			checkboxOption2.click();
			
			//Thread.sleep(2000);
			checkboxOption4.click();
			
			submitBtn.click();
			WebElement responseRecorded = driver.findElement(By.xpath("//div[text()='Your response has been recorded.']"));
			Assert.assertTrue(responseRecorded.isDisplayed());

			WebElement resubmit = driver.findElement(By.xpath("//a[text()='Submit another response']"));
			resubmit.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='i11']")));
		}

		driver.quit();

	}

}

















