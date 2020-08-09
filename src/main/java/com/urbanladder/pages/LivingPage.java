package com.urbanladder.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.config.Constants;

public class LivingPage {
	@FindBy(css = "#topnav_wrapper>ul>li:nth-child(2)")
	private WebElement LivingLink;

	@FindBy(xpath = "//a[text()='Sofa Set']")
	private WebElement Sofa_SetLink;

	@FindBy(xpath = "//a[text()='Sofa cum Bed']")
	private WebElement SofaCumBedLink;

	@FindBy(css = "li.topnav_item.livingunit>div >div >ul>li:nth-child(3) > div>a")
	private WebElement ChairLink;

	@FindBy(xpath = "//a[text()='Tables']")
	private WebElement TableLink;

	@FindBy(css = "li.topnav_item.livingunit > div > div > ul > li:nth-child(5) > div > a")
	private WebElement StorageLink;

	@FindBy(xpath = "//a[text()='Balcony & Outdoor']")
	private WebElement Balcony_OutdoorLink;

	// This is to Initializing the page Objects
	public LivingPage() {
		PageFactory.initElements(Constants.driver, this);
	}

	// This method is to check visibility of 'Living' menu title
	public boolean visibilityOfLivingMenuLink() {
		Constants.isDisplay = LivingLink.isDisplayed();
		return Constants.isDisplay;
	}

	// This method is to check visibility of 'Sofa Set' sub-menu title
	public boolean visibilityOf_Sofa_SetSubMenuLink() {
		Constants.isDisplay = Sofa_SetLink.isDisplayed();
		return Constants.isDisplay;
	}

	// This method is to check Text of 'Sofa Set' sub-menu title
	public String getSofa_SetSubMenuText() {
		return Sofa_SetLink.getText();
	}

	// This method is to check Text of 'Sofa cum Bed' sub-menu title
	public String getSofa_cum_BedSubMenuText() {
		return SofaCumBedLink.getText();
	}

	// This method is to check Text of 'Chair' sub-menu title
	public String getChairSubMenuText() {
		return ChairLink.getText();
	}

	// This method is to check Text of 'Sofa cum Bed' sub-menu title
	public String getTablesSubMenuText() {
		return TableLink.getText();
	}

	// This method is to check Text of 'Storage' sub-menu title
	public String getStorageSubMenuText() {
		return StorageLink.getText();
	}

	// This method is to check Text of 'Sofa cum Bed' sub-menu title
	public String getBalcony_And_OutdoorSubMenuText() {
		return Balcony_OutdoorLink.getText();
	}
}