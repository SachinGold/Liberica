package com.urbanladder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.config.Constants;

public class BedPage {
	
	@FindBy(css="#topnav_wrapper>ul>li:nth-child(3)")
	private WebElement HoverOnBedroom;
	
	@FindBy(xpath="//a[@class='inverted'][contains(text(),'Beds')]")
	private WebElement HoverOn_Beds;
	
	@FindBy(css="li.topnav_item.bedroomunit>div>div>ul>li:nth-child(2)>div>a")
	private WebElement HoverOn_Mattress;
	
	@FindBy(css="li.topnav_item.bedroomunit>div>div>ul>li:nth-child(3)>div>a")
	private WebElement HoverOn_Storage_and_Accessories;
	
	@FindBy(css="li.topnav_item.bedroomunit>div>div>ul>li:nth-child(4)>div>a")
	private WebElement HoverOn_Kids_Bedroom;
	
	// This is to Initializing the page Objects
	public BedPage() {		
		
		PageFactory.initElements(Constants.driver, this);
		
	}
	
	// This method is to check visibility of 'Bedroom' menu title
	public boolean isvisible_BedroomMenuItems() {
		
		Constants.isDisplay = HoverOnBedroom.isDisplayed();
		return Constants.isDisplay;
		
	}
	
	// This method is to check visibility of 'Beds' sub-menu title
	public boolean isvisible_Beds_SubMenu() {
		
		Constants.isDisplay = HoverOn_Beds.isDisplayed();
		return Constants.isDisplay;
		
	}
	
	//This method is to check Text of 'Beds' sub-menu items
	public String getBeds_subMenu_Items() {
		
		return HoverOn_Beds.getText();
		
	}
	
	// This method is to check visibility of 'Mattress' sub-menu title
	public boolean isvisible_Mattress_SubMenu() {
		
		Constants.isDisplay = HoverOn_Mattress.isDisplayed();
		return Constants.isDisplay;

	}
	
	//This method is to check Text of 'Mattress' sub-menu items
	public String getMattresses_subMenu_Items() {
		
		return HoverOn_Mattress.getText();

	}	
	
	//This method is to check Text of 'Storage & Accessories' sub-menu items
	public String getStorage_and_Accessories_subMenu_Items() {
		
		return HoverOn_Storage_and_Accessories.getText();

	}
	
	//This method is to check Text of 'Kids Bedroom' sub-menu items
	public String getKids_Bedroom_Items() {
		
		return HoverOn_Kids_Bedroom.getText();

	}	

}
