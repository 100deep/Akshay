import java.io.FileInputStream;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;


import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Query2 {
	
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		//WebDriver driver = new FirefoxDriver();
		
		int i,j=19,rowcount,rowiterator=200;
		int rc=0,k=1;
		//int content=0;
		StringBuilder pid = new StringBuilder();
		System.setProperty("webdriver.ie.driver","D:\\softwares\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
		WebDriver IEdriver = new InternetExplorerDriver();
		WebElement element;
		
		
		System.out.println("enter url");
		IEdriver.get("http://10.66.22.14:18000/sqlexplorer/");
		
		String Filepath = "Excel_File/CP_PAWK02_20160723_20160722_0730.xlsx";
		
		//Workbook containing query
		FileInputStream Queryfs = new FileInputStream(Filepath);
		Workbook Querywb = WorkbookFactory.create(Queryfs);
		Sheet Querysheet = Querywb.getSheet("CP_PAWK02_20160723_20160722_073");
		Row Queryrow;
		Cell Querycell;
		
		rowcount = Querysheet.getPhysicalNumberOfRows();
		
		while(rowiterator<=rowcount-1){
			
			System.out.println("inside iterator");
			for(i=k;i<=rowiterator;i++)
			{
					
					Queryrow = Querysheet.getRow(i);
					Querycell = Queryrow.getCell(j);
				
					//content = (int) Querycell.getNumericCellValue();
					pid.append((int) Querycell.getNumericCellValue());
					pid.append(',');
				
			}
			k=i;
			System.out.println("done with pid append");
			
			//pid.substring(0, pid.length()-1);
		
			element = IEdriver.findElement(By.xpath(".//*[@id='sql']"));
			element.clear();
			element.sendKeys("select count(*)  from person_d where isblacklisted_email = 1 and person_wid in ("+pid.substring(rc, pid.length()-1)+")");
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			rc=pid.length();
			System.out.println(rc);
			System.out.println(pid.length());
			System.out.println("Query is entered");
			element = IEdriver.findElement(By.xpath(".//*[@id='sqlform']/table/tbody/tr/td[1]/button"));
			element.click();
			System.out.println("After click");
			
			if((rowiterator+200)<rowcount){
				
				rowiterator = rowiterator+200;
				System.out.println(rowiterator);
				System.out.println(rowcount);
				//element = IEdriver.findElement(By.xpath(".//*[@id='rows']/tbody/tr/td"));
				//String expectedcontent =  element.getText();
				//System.out.println(expectedcontent);
			}
			
			else if((rowiterator+200)>rowcount && rowiterator!=rowcount-1){
				
				rowiterator = rowcount-1;
				System.out.println(rowiterator);
				System.out.println(rowcount);
				//element = IEdriver.findElement(By.xpath(".//*[@id='rows']/tbody/tr/td"));
				//String expectedcontent =  element.getText();
				//System.out.println(expectedcontent);
			}
			
			else{
				rowiterator=rowiterator+2;
			}
			
			System.out.println("iteration complete");
			/*IEdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			element = IEdriver.findElement(By.xpath(".//*[@id='rows']/tbody/tr/td"));
			String expectedcontent =  element.getText();
			System.out.println(expectedcontent);*/
		}
	}


	

}
