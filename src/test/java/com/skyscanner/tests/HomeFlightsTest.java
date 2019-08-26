package com.skyscanner.tests;

import com.skyscanner.base.TestBase;
import com.skyscanner.pages.HomeFlightsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeFlightsTest extends TestBase {
  HomeFlightsPage homeFlightsPage;

  public HomeFlightsTest() {
    super();
  }

  @BeforeMethod
  public void setUp() throws InterruptedException {
    initialization();
    homeFlightsPage = new HomeFlightsPage(driver);
  }

  @Test
  public void testFlight() {
    homeFlightsPage.flightSearch("lhr", "hyd");
  }

  @AfterMethod(enabled = false)
  public void tearDown() {
    driver.quit();
  }
}
