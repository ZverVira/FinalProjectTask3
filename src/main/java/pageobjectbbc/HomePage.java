package pageobjectbbc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    private static final String NEWS_MENU_ITEM = "//div[@id = 'orb-nav-links']//a[contains(@href,'https://www.bbc.com/news')]";
    private static final String SPORT_MENU_ITEM = "//div[@id = 'orb-nav-links']//a[contains(@href,'https://www.bbc.com/sport')]";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void moveToNewsPage() {
        driver.findElement(xpath(NEWS_MENU_ITEM)).click();
    }

    public void moveToSportPage() {
        driver.findElement(xpath(SPORT_MENU_ITEM)).click();
    }
}
