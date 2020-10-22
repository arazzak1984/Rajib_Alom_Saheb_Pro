package Data_XL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Use_XL {
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet shit;
	XSSFCell ce;
	
	@BeforeMethod
	public void initialStep() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver Latest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
	}
	
	
	
	@Test
	public void xlTest() throws IOException, InterruptedException {
		
		// To identify the xl file:------------->>
		File src = new File("C:/Users/Sumon/Desktop/Class Stuff/FB_Database.xlsx");
		
		// Create fileinput stream object to read xl:--------->>>
		FileInputStream fis = new FileInputStream(src);
		
		//To access workbook:---->>
		wb = new XSSFWorkbook(fis);
		
		// To access Sheet:--->>>
		shit = wb.getSheetAt(0);
		for(int i =1; i<=shit.getLastRowNum();i++) {
			
			
		// To Access cell:----->>>>
		ce =shit.getRow(i).getCell(0);
		ce.setCellType(CellType.STRING);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(ce.getStringCellValue());
		Thread.sleep(2000);
		
		ce =shit.getRow(i).getCell(1);
		ce.setCellType(CellType.STRING);
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(ce.getStringCellValue());
		Thread.sleep(2000);
		
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(7000);
		
		
			
		
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
