package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	public static ExtentTest logger;
	
	 private By routeIconLocator = By.id("route-icon");
	    private By searchOneMapLocator = By.id("search_property");
	    private By originInputLocator = By.id("originInput");
	    private By destinationInputLocator = By.id("destinationInput");
	    private By markerInfoboxLocator = By.id("markerInfobox");
	    private By searchresult_nameLocator = By.xpath("//*[@id='search-input-wrapper']/div/li[1]");
	    private By logoLocator = By.xpath("//*[@id='onemap3Btn']/img");
	    private By CommunityLocator = By.id("Community");
	    private By btn2D3DLocator = By.id("btn2D3D");
	    
	
	  
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
//		ßwait = new WebDriverWait(driver, 50);
	}
	
	public String getTitle() throws InterruptedException {
		Thread.sleep(1000);
		return driver.getTitle();
	}

	// Methods
	 public boolean logoDisplay(){
	        return driver.findElement(logoLocator).isDisplayed();
	    }
	
		public void clickRouteIcon() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(routeIconLocator)).isDisplayed();
	        WebElement routeIcon = driver.findElement(routeIconLocator);
	        wait.until(ExpectedConditions.elementToBeClickable(routeIcon));
	        routeIcon.click();
	    }

		public void enterLocation(String location) {
	        WebElement searchOneMap = driver.findElement(searchOneMapLocator);
	        searchOneMap.clear();
	        searchOneMap.sendKeys(location);
	        searchresultSelection(location);
	    }
		
		public void searchresultSelection(String location) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchresult_nameLocator)).isDisplayed();
		    Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
	    }
	    public void originInput(String location) {
	    	
	        WebElement originInput = driver.findElement(originInputLocator);
	        wait.until(ExpectedConditions.elementToBeClickable(originInput));
	        originInput.clear();
	        originInput.sendKeys(location);
	        searchresultSelection(location);
	    }

	    public void destinationInput(String location) {
	        WebElement destinationInput = driver.findElement(destinationInputLocator);
	        destinationInput.clear();
	        destinationInput.sendKeys(location);
	        searchresultSelection(location);
	    }

	    public boolean checkmarkerInfoboxTxt(){
	        return driver.findElement(markerInfoboxLocator).isDisplayed();
	    }
	    public String markerInfoboxTxt() {
	        WebElement markerInfobox = driver.findElement(markerInfoboxLocator);
	        return markerInfobox.getText();
	    } 

	    public String checkCommunityAttribute() {
	        WebElement Community = driver.findElement(CommunityLocator);
	        String value = Community.getAttribute("class");
	        return value;     
	    }
	    
	    public void clickCommunity() throws InterruptedException {
	    	WebElement Community = driver.findElement(CommunityLocator);
	    	Community.click();
	    	Thread.sleep(1000);
	    }
	    public String checkbtn2D3DAttribute() {
	        WebElement btn2D3D = driver.findElement(btn2D3DLocator);
	        String value = btn2D3D.getAttribute("class");
	        return value;     
	    }
	    
	    public void clickbtn2D3D() {
	    	WebElement btn2D3D = driver.findElement(btn2D3DLocator);
	    	btn2D3D.click();
	    }
}
