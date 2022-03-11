import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIPage {
	By MacButtonInHeader = By.xpath("//*[@id=\"ac-globalnav\"]/div/ul[2]/li[3]/a");
	public WebDriver SetUp() 
	{
		WebDriver driver = new ChromeDriver();
    	System.setProperty("webdriver.chrome.driver","src/chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/mx/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	public void Click(WebElement element) 
	{
		element.click();
	}
	public void FillField(WebElement element,String textValue) 
	{
		element.sendKeys(textValue);
	}
	public void waitForUI() {
		try
		{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	public void ClickWhenEnabled(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	

	
}
