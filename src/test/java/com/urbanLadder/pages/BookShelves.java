package com.urbanLadder.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookShelves extends BasePage {
	
	public BookShelves(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//li[@class='topnav_item livingunit']//span[@class='topnav_itemname']")
	WebElement living;
	@FindBy(xpath="//a[@href='/bookshelf?src=g_topnav_living_living-storage_bookshelves']")
	WebElement bookShelves;
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement close;
	@FindBy(xpath="//li[@data-group='storage type']")
	WebElement StorageType;
	@FindBy(xpath="//input[@id='filters_storage_type_Open']")
	WebElement open;
	@FindBy(xpath="//li[@class='item' and @data-group='price']")
	WebElement priceBox;
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement sliderHandle;
	@FindBy(xpath="//input[@name='filters[availability][]'][@id='filters_availability_In_Stock_Only']")
	WebElement excludeStock;
	@FindBy(xpath="(//*[@id=\"content\"]/div[3]/ul/li/div/div[5]/a/div[1]/span)[position()<=3]")
	List<WebElement> books;
	@FindBy(xpath="(//*[@id=\"content\"]/div[3]/ul/li/div/div[5]/a/div[2]/span)[position()<=3]")
	List<WebElement> prices;
	
	public static void explicitWait(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	public void moveToLiving() {
		Actions a = new Actions(driver);
		a.moveToElement(living).perform();
	}
	public void clickBookShelves() {
		//bookShelves.click();//
		explicitWait(bookShelves, 10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", bookShelves);
		 
		
	}
	public void closePopup() {
		//close.click();//
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(close));
		close.click();
	 
	}
	public void moveToPrice() {
		explicitWait(priceBox,10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", priceBox);
    	Actions a = new Actions(driver);
        a.moveToElement(priceBox).perform();  
	}
	public void moveSlider() {
		explicitWait(sliderHandle,10);
		Actions a = new Actions(driver);
		a.dragAndDropBy(sliderHandle, -230, 0).perform();
	}
	/*public void storageType() {
		Actions a = new Actions(driver);
		a.moveToElement(StorageType).perform();
		//open.click();//
	}*/
	public void openType()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", StorageType);
		 
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(StorageType)).click();
		Actions a = new Actions(driver);
		a.moveToElement(StorageType).perform();
		 
		 
		wait.until(ExpectedConditions.visibilityOf(open));
		wait.until(ExpectedConditions.elementToBeClickable(open));
		 
		 
		js.executeScript("arguments[0].click();", open);
		 
	}
	
	public void clickExcludeStock() {
		/*explicitWait(excludeStock,10);
		excludeStock.click();*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 
		js.executeScript("arguments[0].scrollIntoView(true);", excludeStock);
		 
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(excludeStock));
		 
		 
		js.executeScript("arguments[0].click();", excludeStock);
	}
	public void displayNamesandPrices() {
		System.out.print(books.size()+"-"+prices.size());
		
		for(int i=0;i<3;i++)
        {
			/*explicitWait(books.get(i),10);
         System.out.println(books.get(i).getText()+"-"+prices.get(i).getText());*/
			//try {
	           // explicitWait(books.get(i), 10);
	           // explicitWait(prices.get(i), 10);
	            System.out.println(books.get(i).getText() + " - " + prices.get(i).getText());
	       // } catch (IndexOutOfBoundsException e) {
	           // System.out.println("Failed to access bookshelf or price at index " + i + ": " + e.getMessage());
	        //}
        }
		//return null;
		
	}
	public String[] name() {
		int i=0;
		String[] res = new String[3];
		for(WebElement w : books) {
			res[i] = w.getText();
			i++;
		}
		return res;
	}
	public String[] price() {
		int i=0;
		String[] res = new String[3];
		for(WebElement p : prices) {
			res[i] = p.getText();
			i++;
		}
		return res;
	}
	
}
