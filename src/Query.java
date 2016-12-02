import java.io.FileInputStream;
import java.io.IOException;

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
import org.openqa.selenium.firefox.FirefoxDriver;


public class Query {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		WebDriver driver = new FirefoxDriver();
		WebElement element;
		int i,j=19;
		
		System.out.println("enter url");
		driver.get("http://10.66.22.14:18000/sqlexplorer/");
		
		String Filepath = "Excel_File/CP_PAWK02_20160723_20160722_0730.xlsx";
		
		//Workbook containing query
		FileInputStream Queryfs = new FileInputStream(Filepath);
		Workbook Querywb = WorkbookFactory.create(Queryfs);
		Sheet Querysheet = Querywb.getSheet("CP_PAWK02_20160723_20160722_073");
		
		for(i=1;i<3;i++)
		{
				Row Queryrow = Querysheet.getRow(i);
				Cell Querycell = Queryrow.getCell(j);
				int content = (int) Querycell.getNumericCellValue();
				String cellcontent = Integer.toString(content);
				//Querysheet.rowIterator();
				element = driver.findElement(By.xpath(".//*[@id='sql']"));
				element.clear();
				element.sendKeys("select person_wid  from person_d where isblacklisted_email = 1 and person_wid = "+content);
				
				element = driver.findElement(By.xpath(".//*[@id='sqlform']/table/tbody/tr/td[1]/button"));
				element.click();
				
				element = driver.findElement(By.xpath(".//*[@id='rows']/tbody/tr/td"));
				String expectedcontent =  element.getText();
				
				
				if (expectedcontent == cellcontent)
				{
					System.out.println(expectedcontent);
				}
		}
		
		
		
		
		

	}

}
