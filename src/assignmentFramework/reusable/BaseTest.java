package reusable;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	
	public static ExtentTest logger;
	public static ExtentReports report;
	public static WebDriver driver;
    protected Properties properties = new Properties();

    
    
    @BeforeSuite
	public void startContainer() throws IOException
	{
    	 try {
             // Path to your shell script
             String scriptPath = "./startdockerGrid.sh";

             // Create a ProcessBuilder to run the script
             ProcessBuilder processBuilder = new ProcessBuilder("bash", scriptPath);
             processBuilder.redirectErrorStream(true);

             // Start the process
             Process process = processBuilder.start();

             // Read the script's output
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             String line;
             while ((line = reader.readLine()) != null) {
                 System.out.println(line);
             }
             Thread.sleep(5000);

             int exitCode = process.waitFor();
             System.out.println("Exited with code: " + exitCode);

         } catch (Exception e) {
             e.printStackTrace();
         }
     
	}
    
    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        FileInputStream configFile = new FileInputStream("./Configuration.properties");
        properties.load(configFile);
        
        String hubURL=properties.getProperty("hubURL");
        
    	
        // Set base URI from properties
        String uRL = properties.getProperty("URL");
        int timeout = Integer.parseInt(properties.getProperty("timeout"));
        
        
               
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "./Download");
		prefs.put("profile.default_content_settings.geolocation", 1);
		options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");
		options.setExperimentalOption("prefs", prefs);
        
        
		driver=new RemoteWebDriver(new URL(hubURL), options);
//		Thread.sleep(5000);
        driver.manage().window().maximize();
        
		driver.get(uRL);
       
		Thread.sleep(2000);
		

		
		
		
		
    }
    
    @AfterClass(alwaysRun=true)
	public void tearDown() throws IOException {
    	if (driver != null) {
            driver.quit();
        }
	}
    
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Closing browser...");
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.");
        } else {
            System.out.println("Driver was null.");
        }
    }
    @AfterSuite
	public void stopContainer()
	{
    	 try {
             // Path to your shell script
             String scriptPath = "./stopdockerGrid.sh";

             // Create a ProcessBuilder to run the script
             ProcessBuilder processBuilder = new ProcessBuilder("bash", scriptPath);
             processBuilder.redirectErrorStream(true);

             // Start the process
             Process process = processBuilder.start();

             // Read the script's output
             BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             String line;
             while ((line = reader.readLine()) != null) {
                 System.out.println(line);
             }

             int exitCode = process.waitFor();
             System.out.println("Exited with code: " + exitCode);

         } catch (Exception e) {
             e.printStackTrace();
         }
	}
    
}

