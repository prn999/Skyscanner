package com.skyscanner.pages;

import com.skyscanner.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFlightsPage extends TestBase {

  //WebElements Repository
  @FindBy(xpath = "//input[@id='fsc-origin-search']")
  @CacheLookup
  WebElement from;
  @FindBy(xpath = "//input[@id='fsc-destination-search']")
  @CacheLookup
  WebElement to;
  @FindBy(xpath = "//button[@type='submit']")
  @CacheLookup
  WebElement searchFlightsButton;

  public HomeFlightsPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public SearchResults flightSearch(String fromAirport, String toAirport) {
    from.clear();
    from.sendKeys(fromAirport);
    to.clear();
    to.sendKeys(toAirport);
    searchFlightsButton.click();
    return new SearchResults();
  }

}

