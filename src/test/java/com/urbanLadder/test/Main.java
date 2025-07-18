package com.urbanLadder.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;

import com.urbanLadder.pages.BeingAtHome;
import com.urbanLadder.pages.BookShelves;
import com.urbanLadder.pages.CheckOutPage;
import com.urbanLadder.pages.ConnectWithUs;
import com.urbanLadder.pages.Showcases;
import com.urbanLadder.pages.StudyChairs;
import com.urbanLadder.setup.DriverSetup;
import com.urbanLadder.setup.ExcelUtils;

public class Main {
     public static void main(String args[]) throws IOException, URISyntaxException {
    	 String xlFile, beingAtHomeSheet, bookShelvesSheet, studyChairsSheet;
  		String[] beingAtHome, bookShelves, studyChairs, price, chairPrices;
  		xlFile = System.getProperty("user.dir") + "\\src\\test\\resources\\DataSet.xlsx";
  		beingAtHomeSheet = "Sheet2";
  		bookShelvesSheet = "Sheet3";
  		studyChairsSheet = "Sheet4";
    	 DriverSetup d=new DriverSetup();
    	 WebDriver driver=d.driverInstantiate("chrome");
    	 BookShelves Bookobj=new BookShelves(driver);
    	 Bookobj.moveToLiving();
    	 Bookobj.clickBookShelves();
    	 Bookobj.closePopup();
    	 Bookobj.moveToPrice();
    	 Bookobj.moveSlider();
    	 //Bookobj.storageType();
    	 Bookobj.openType();
    	 Bookobj.clickExcludeStock();
    	 Bookobj.displayNamesandPrices();
    	 
     	 bookShelves = Bookobj.name();
  
         for(int i = 0 ; i < bookShelves.length ; i++) {
     		 ExcelUtils.setCellData(xlFile, bookShelvesSheet, i+1, 1, bookShelves[i]);
     	 }
     	 price = Bookobj.price();
     	 for(int i = 0 ; i < price.length ; i++) {
     		 ExcelUtils.setCellData(xlFile, bookShelvesSheet, i+1, 2, price[i]);
     	 }
 

    	 StudyChairs studyobj=new StudyChairs(driver);
    	 studyobj.moveToStudy();
    	 studyobj.clickStudyChair();
    	 studyobj.scrollToStudyChairs();
    	 studyobj.DisplayChairsPrices();
    	 studyChairs =  studyobj.name();
     	 for(int i = 0 ; i < studyChairs.length ; i++) {
     		 ExcelUtils.setCellData(xlFile, studyChairsSheet, i+1, 1, studyChairs[i]);
     	 }
     	 chairPrices = studyobj.price();
     	 for(int i = 0 ; i < chairPrices.length ; i++) {
     		 ExcelUtils.setCellData(xlFile, studyChairsSheet, i+1, 2, chairPrices[i]);
     	 }
    	 BeingAtHome homeobj=new BeingAtHome(driver);
    	 homeobj.searchBeingatHome();
    	 homeobj.clickSearch();
    	 homeobj.selectCategory();
    	 homeobj.DisplaySubItems(); 
    	 beingAtHome = homeobj.DisplaySubItems();
     	 for(int i = 0 ; i < beingAtHome.length ; i++) {
     		 ExcelUtils.setCellData(xlFile, beingAtHomeSheet, i+1, 1, beingAtHome[i]);
     	 }
    	 
    	 CheckOutPage checkObj=new CheckOutPage(driver);
    	 checkObj.clickProduct();
    	 checkObj.moveToCart();
    	 checkObj.DoCheckOut();
    	 checkObj.passEmail();
    	 checkObj.DisplayErrorMsg();
    	 ConnectWithUs connectObj=new ConnectWithUs(driver);
    	 connectObj.ClickOnLogo();
    	 connectObj.Connect();
    	 connectObj.DisplayConnections();
    	 
    	 Showcases show=new Showcases(driver);
    	 show.moveToLiving();
    	 show.clickshowcases();
    	 show.closedType();
    	 show.clickExcludeStock();
    	 show.displayNamesandPrices();
     }
}
