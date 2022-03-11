import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class AutoTest {

	private UIPage program = new UIPage();
	private WebDriver driver; 
	public void searchIphone13Results() {
		WebElement elementSearch, elementFill;
		
		elementSearch = driver.findElement(By.xpath("//*[@id=\"ac-gn-link-search\"]"));
		program.Click(elementSearch);
		
		elementFill = driver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-input\"]"));
		program.FillField(elementFill, "iPhone 13");
		
		elementFill.sendKeys(Keys.RETURN);
		
	}
	public void goToIphone13Page() {
		goToMacTab();
		WebElement elementSearch, elementFill, elementClick;
		elementSearch = driver.findElement(By.xpath("//*[@id=\"ac-gn-link-search\"]"));
		program.Click(elementSearch);
		
		elementFill = driver.findElement(By.xpath("//*[@id=\"ac-gn-searchform-input\"]"));
		program.FillField(elementFill, "iPhone 13");
	//	program.waitForUI();
		
		elementClick = driver.findElement(By.xpath("//*[@id=\"quicklinks\"]/li[1]/a"));
		program.Click(elementClick);
		
	}
	public void goToMacTab() {
		WebElement element;
		element = driver.findElement(program.MacButtonInHeader);
		program.Click(element);
	
	}
    @BeforeClass
    public void beforeClass() {
    	
    	
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
    	driver =new ChromeDriver();
    	String baseUrl = "https://www.apple.com/mx";
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get(baseUrl);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void validateIfIphone13LabelAreDisplayed() {
    		 goToIphone13Page();
        	 String iphone13MainInfo = "iPhone 13 Pro";
        	 program.waitForUI();
             WebElement iphone13MainLabel = driver.findElement(By.xpath("/html/body/nav[2]/div/div[2]/div[1]/a"));
             String text = iphone13MainLabel.getText();
             Assert.assertEquals(text, iphone13MainInfo, "Text Not found!");  
    }
    
    @Test
    public void validateIphone13MenuOptions() {
    		 goToIphone13Page();
        	 program.waitForUI();
        	 WebElement changeToIphone, specs, buy;
        	 changeToIphone = driver.findElement(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[3]/div[1]/ul/li[2]/a"));
        	 specs = driver.findElement(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[3]/div[1]/ul/li[3]/a"));
        	 buy = driver.findElement(By.xpath("//*[@id=\"ac-localnav\"]/div/div[2]/div[3]/div[2]/div[2]/a"));
        	 Assert.assertTrue(buy.isEnabled());
        	 Assert.assertTrue(specs.isEnabled());
        	 Assert.assertTrue(changeToIphone.isEnabled());
    
             
    
            
    }
    
    @Test
    public void validateIfWeAreInIphone13Page() {
    		searchIphone13Results();
        	 String iphone13Info = "iPhone 13 Pro y iPhone 13 Pro Max";
             WebElement iphone13Label = driver.findElement(By.xpath("//*[@id=\"exploreCurated\"]/div[1]/div[2]/h2/a"));
             String text = iphone13Label.getText();
             Assert.assertEquals(text, iphone13Info, "Text Not found!");  
    }
    
    @Test
    public void validateInnovationTextInMacTab() {
    	goToMacTab();
        String search_text = "Innovación a la vista.";
        WebElement innovationText = driver.findElement(By.xpath("//*[@id=\"main\"]/section[2]/div/div/p"));
        String text = innovationText.getText();
        Assert.assertEquals(text, search_text, "Text not found!");
    }
    @Test
    public void validatePowerTextInMacTab() {
    	goToMacTab();
        String powerText = "Poder para poder.";
        WebElement power4PowerText = driver.findElement(By.xpath("//*[@id=\"main\"]/section[1]/div/div/p"));
        String text = power4PowerText.getText();
        Assert.assertEquals(text, powerText, "Text Not found!");
    }
}
