package Data_XL;

import java.io.File;
import java.io.FileInputStream;
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

public class SignUP {
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
		
		driver.findElement(By.xpath("//a[contains(@id,'u_0_2')]")).click();
		
		File src = new File("C:/Users/Sumon/Desktop/Class Stuff/FB_Database.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		
		shit = wb.getSheetAt(1);
		for(int i =1; i<=shit.getLastRowNum();i++) {
			
		ce =shit.getRow(i).getCell(0);
		ce.setCellType(CellType.STRING);
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(ce.getStringCellValue());
		Thread.sleep(2000);
		
		ce =shit.getRow(i).getCell(1);
		ce.setCellType(CellType.STRING);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(ce.getStringCellValue());
		Thread.sleep(2000);
		}
		}
}
