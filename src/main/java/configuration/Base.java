package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop= new Properties();
 		FileInputStream fis= new FileInputStream("C:\\Users\\Roy Cerpa\\Documents\\NetBeansProjects\\ProyAATT\\src\\main\\java\\configuration\\data.properties");
                
		prop.load(fis);
		String browserName= prop.getProperty("browser");
	
		if(browserName.contains("firefox")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			  driver= new FirefoxDriver();
		}else if(browserName.contains("chrome")) {
			  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			  driver= new ChromeDriver();
		}else {
			  System.setProperty("webdriver.ie.driver", "C:\\msedgedriver.exe");
			  driver= new InternetExplorerDriver();
	    }
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		return driver;	
	}	

    }    
        
        
        
    /*    
        //FileInputStream fis= new FileInputStream("C:\\Users\\UserTBS1\\eclipse-workspace\\BFMQA\\src\\main\\java\\configuration\\data.properties");
	public void getScreenshot(String result) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\ScreenShotData\\CONSENSUS2.0\\"+ result + "screenshot.png"));
	}
	

*/

