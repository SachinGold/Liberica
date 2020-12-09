package com.test;

//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.config.Constants;
import com.config.Keywords;
import com.urbanladder.pages.BedPage;
import com.utility.PropertyUtility;

public class BedroomPageTest {	
	
	BedPage bed_page;
	String LivingPagePropertyPath = "src\\main\\resources\\BedroomPage.properties";
	String BedPageItemsJsonPath = "src/main/resources/BedPageItems.json";
	
	
	@BeforeTest
	public void tc_openBrowser() {
		
		Keywords.openBrowser("Chrome");
		Keywords.launchURL(PropertyUtility.getProperty("ApplicationURL", LivingPagePropertyPath));
		Keywords.maximizeBrowser();
		String expectedurl = Constants.driver.getCurrentUrl();
		Assert.assertEquals(expectedurl, "https://www.urbanladder.com/");
		Keywords.loggerInfo("Open browser ,Entering appliction url and maximizing browser");
		Keywords.sleep(10000);
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("StatingPop_up", LivingPagePropertyPath));
		bed_page = new BedPage();	
		
	}
	
	@Test(priority=1)
	public void tc_BedroomMenuDisplay() {
		
		bed_page.isvisible_BedroomMenuItems();
		Assert.assertTrue(true);
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.loggerInfo("Verify 'Bedroom' Menu is visible or not");

	}
	
	@Test(priority=2)
	public void tc_Beds_SubMenuDisplay() {
		
		Keywords.sleep(3000);
		Constants.actual = bed_page.getBeds_subMenu_Items();
		Constants.expected = "Beds";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Beds' text");
		
	}
	
	@Test(priority=3)
	public void tc_BedsSubMenuItems() {
		
		List<WebElement> BedsSubMenuList = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Beds_SubMenu", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = BedsSubMenuList.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Beds List :-" + Constants.actualList);
		Keywords.readJsonFile(BedPageItemsJsonPath, "Beds");
		Keywords.loggerInfo("verify 'Beds' sub Menu List(Items) from Bedroom Menu");

	}
	
	@Test(priority=4)
	public void get_Mattresses_SubMenuText() {
		
		Constants.actual = bed_page.getMattresses_subMenu_Items();
		Constants.expected = "Mattresses";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Mattresses' text");
		
	}
	
	@Test(priority=5)
	public void get_Mattresses_SubMenuList() {
		
		List<WebElement> MattressesSubMenuList = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Mattresses_SubMenu", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = MattressesSubMenuList.iterator();
		while (itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Mattresses List :-" + Constants.actualList);
		Keywords.readJsonFile(BedPageItemsJsonPath, "Mattresses");
		Keywords.loggerInfo("verify 'Mattresses' sub Menu List(Items) from Bedroom Menu");

	}
	
	@Test(priority=6)
	public void get_Storage_and_Accessories_subMenu() {
		
		Constants.actual = bed_page.getStorage_and_Accessories_subMenu_Items();
		Constants.expected = "Storage & Accessories";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Storage & Accessories' text");
		
	}
	
	@Test(priority=7)
	public void get_Storage_and_Accessories_subMenuList() {
		
		List<WebElement> Storage_Accessories_SubMenuList = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Storage_and_AccessoriesMenu", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = Storage_Accessories_SubMenuList.iterator();
		while(itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Storage & Accessories List : " + Constants.actualList);
		Keywords.readJsonFile(BedPageItemsJsonPath, "Storage & Accessories");
		Keywords.loggerInfo("verify 'Storage & Accessories' sub Menu List(Items) from Bedroom Menu");

	}
	
	@Test(priority=8)
	public void get_Kids_Bedroom_subMenu() {
		
		Constants.actual = bed_page.getKids_Bedroom_Items();
		Constants.expected = "Kids Bedroom";
		Assert.assertEquals(Constants.actual, Constants.expected);
		Keywords.loggerInfo("Verify actual 'Kids Bedroom' text");
	}
	
	@Test(priority=9)
	public void get_Kids_Bedroom_subMenuList() {
		
		List<WebElement> Kids_Bedroom_SubMenuList = Constants.driver.findElements(
				By.cssSelector(PropertyUtility.getProperty("Kids_BedroomMenu", LivingPagePropertyPath)));
		Constants.actualList = new ArrayList<String>();
		Iterator<WebElement> itr = Kids_Bedroom_SubMenuList.iterator();
		while(itr.hasNext()) {
			Constants.actualList.add(itr.next().getText());
		}
		System.out.println("Actual Kids Bedroom List : " + Constants.actualList);
		Keywords.readJsonFile(BedPageItemsJsonPath, "Kids Bedroom");
		Keywords.loggerInfo("verify 'Kids Bedroom' sub Menu List(Items) from Bedroom Menu");

	}
	
	@Test(priority=10)
	public void tc_Beds() {
		
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds", LivingPagePropertyPath));
		String actualTitle = Constants.driver.getTitle();
		String expectedTitle = "Beds: Buy Beds Online in India at Best Prices @ No Cost EMI - Urban Ladder";
		Assert.assertEquals(actualTitle, expectedTitle);
		Constants.driver.navigate().back();

	}
	
	@Test(priority=11)
	public void tc_Beds_with_Storage_Price_Low_to_High() {
		
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds_with_Storage", LivingPagePropertyPath));
		Keywords.chk_Selectcheckbox("CSS", PropertyUtility.getProperty("Exclude_Out_Of_Stock", LivingPagePropertyPath));
		Keywords.sleep(7000);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("Sort_By", LivingPagePropertyPath));	
		Keywords.clickOnElement("CSS",PropertyUtility.getProperty("Low_To_High", LivingPagePropertyPath));
		String actualTitle = Constants.driver.getTitle();
		String expectedTitle = "Storage Bed: Buy Storage Beds Online | Get up to 50% Off - Urban Ladder";
		Assert.assertEquals(actualTitle, expectedTitle);
		Constants.driver.navigate().back();
		Keywords.sleep(4000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		
	}
	
	@Test(priority=12)
	public void tc_Beds_with_Storage_Price_High_to_Low() {
		
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds_with_Storage", LivingPagePropertyPath));
		Keywords.chk_Selectcheckbox("CSS", PropertyUtility.getProperty("Exclude_Out_Of_Stock", LivingPagePropertyPath));
		Keywords.sleep(7000);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("Sort_By", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS",PropertyUtility.getProperty("High_To_Low", LivingPagePropertyPath));
		String actualTitle = Constants.driver.getTitle();
		String expectedTitle = "Storage Bed: Buy Storage Beds Online | Get up to 50% Off - Urban Ladder";
		Assert.assertEquals(actualTitle, expectedTitle);
		Constants.driver.navigate().back();
		Keywords.sleep(4000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();

	}
	
	@Test(priority=13)
	public void tc_Beds_with_Storage_New_Arrival() {
		
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds_with_Storage", LivingPagePropertyPath));
		Keywords.chk_Selectcheckbox("CSS", PropertyUtility.getProperty("Exclude_Out_Of_Stock", LivingPagePropertyPath));
		Keywords.sleep(7000);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("Sort_By", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS",PropertyUtility.getProperty("New_Arrival", LivingPagePropertyPath));
		String actualTitle = Constants.driver.getTitle();
		String expectedTitle = "Storage Bed: Buy Storage Beds Online | Get up to 50% Off - Urban Ladder";
		Assert.assertEquals(actualTitle, expectedTitle);
		Constants.driver.navigate().back();
		Keywords.sleep(4000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();

	}
	
	@Test(priority=14)
	public void tc_Beds_with_Storage_Discount() {
		
		Keywords.hoverOnElement("CSS",PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds_with_Storage", LivingPagePropertyPath));
		Keywords.chk_Selectcheckbox("CSS", PropertyUtility.getProperty("Exclude_Out_Of_Stock", LivingPagePropertyPath));
		Keywords.sleep(7000);
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("Sort_By", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS",PropertyUtility.getProperty("Discount", LivingPagePropertyPath));
		String actualTitle = Constants.driver.getTitle();
		String expectedTitle = "Storage Bed: Buy Storage Beds Online | Get up to 50% Off - Urban Ladder";
		Assert.assertEquals(actualTitle, expectedTitle);
		Constants.driver.navigate().back();
		Keywords.sleep(4000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();
		Keywords.sleep(2000);
		Constants.driver.navigate().back();

	}
	
	@Test(priority=15)
	public void tc_Beds_with_Storage_Sort_By_Price() {
		
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("BedroomMenu", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Beds_with_Storage", LivingPagePropertyPath));
		Keywords.hoverOnElement("CSS", PropertyUtility.getProperty("Price", LivingPagePropertyPath));
		Keywords.clickOnElement("CSS", PropertyUtility.getProperty("Price_Range_1", LivingPagePropertyPath));
		Keywords.sleep(3000);
		try {
			Keywords.captureFullScreenshot();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
