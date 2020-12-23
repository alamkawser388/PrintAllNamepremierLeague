package com.alam.all;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextAllName {

	public static void main(String[] args) throws Throwable {
		
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"advertClose\"]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'I accept cookies from this site')]")).click();
		
	    List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr/td[3]/a/span[2]"));
	    
	    XSSFWorkbook wb = new  XSSFWorkbook();
	    XSSFSheet sheet = wb.createSheet();
	    
	    for (int i=0; i< teams.size();i++) {
	    	
	    	Row row = sheet.createRow(i);
	    	Cell cell = row.createCell(0);
	    	
	    	cell.setCellValue(teams.get(i).getText().trim());
	    	FileOutputStream fso = new FileOutputStream("C:\\Users\\alamk\\OneDrive\\Desktop\\New folder (3)\\allName.xlsx");
	    	wb.write(fso);
	    	fso.close();
	    
	    
	    
	    
	    
	    }
}
}