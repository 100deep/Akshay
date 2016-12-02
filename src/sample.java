import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class sample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.ie.driver","D:\\softwares\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		WebElement element;
		driver.get("http://10.66.22.14:18000/sqlexplorer/");
		element = driver.findElement(By.xpath(".//*[@id='sql']"));
		element.clear();
		element.sendKeys("select top 10 * from person_d");
		element = driver.findElement(By.xpath(".//*[@id='sqlform']/table/tbody/tr/td[1]/button"));
		element.click();
		//element = driver.findElement(By.id("rows"));
		//System.out.println(element.getText());
		
		List<WebElement> list;
		list = driver.findElements(By.xpath(".//*[@id='rows']/tbody/tr"));
		System.out.println(list.size());
		
		int rowcount = driver.findElements(By.xpath(".//*[@id='rows']/tbody/tr")).size();
		System.out.println(rowcount);
	}

}
