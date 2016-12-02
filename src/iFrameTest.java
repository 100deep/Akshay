import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameTest {

	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\softwares\\chromedriver_win32_2.25\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
        driver.manage().window().maximize();
        
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        System.out.println(iframe.get(4));
        
	}

}
