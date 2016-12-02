import java.io.FileInputStream;
import java.io.FileOutputStream;
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

public class Count {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://10.66.12.14:18000/sqlexplorer/");
		int i,j=1,k=2;
		
		//Excel file path
		String Filepath = "Excel_File/AIE_rowcount.xlsx";
		
		//Workbook containing query
		FileInputStream Queryfs = new FileInputStream(Filepath);
		Workbook Querywb = WorkbookFactory.create(Queryfs);
		Sheet Querysheet = Querywb.getSheet("Sheet1");
		
		
		
		for(i=1;i<37;i++)
		{
				Row Queryrow = Querysheet.getRow(i);
				Cell Querycell = Queryrow.getCell(j);
				String content = Querycell.getStringCellValue();
				
				WebElement element = driver.findElement(By.xpath(".//*[@id='sql']"));
				element.clear();
				element.sendKeys(content);
				
				element = driver.findElement(By.xpath(".//*[@id='sqlform']/table/tbody/tr/td[1]/button"));
				element.click();
				
				element = driver.findElement(By.xpath(".//*[@id='rows']/tbody/tr/td"));
				String count = element.getText();
				Cell Resultcell = Queryrow.createCell(k);
				Row Resultrow = Querysheet.getRow(i);
				Resultcell = Resultrow.getCell(k);
				Resultcell.setCellType(Cell.CELL_TYPE_STRING);
				Resultcell.setCellValue(count);
				
						
		}
		
		//Write output in same file		
		FileOutputStream Resultfs= new FileOutputStream(Filepath);
		
		//Write the count to the file
		Querywb.write(Resultfs);
		Queryfs.close();
		driver.close();
		
		//Opens excel sheet
		//Runtime.getRuntime().exec("cmd /c start "+Filepath);
		
		
	}

}
