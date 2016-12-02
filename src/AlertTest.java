import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTest {

	static WebDriver driver;
	
	
	public static void main(String[] args) {
		
        //String path = System.getProperty("D:\\softwares\\chromedriver_win32_2.25\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver_win32_2.25\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
        driver.manage().window().maximize();
        
        System.out.println("B4 Alert Clicked");
        driver.findElement(By.xpath("//*[@id='content']/p[4]/button")).click();
        Alert simplalrt= driver.switchTo().alert();
        System.out.println("Alert Clicked");
        
        System.out.println("Alert text is: "+" "+ simplalrt.getText());
        simplalrt.accept();
        System.out.println("Alert accepted");



	}

}
