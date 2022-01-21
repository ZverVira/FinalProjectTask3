package pagefactorybbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id = 'orb-nav-links']//a[contains(@href,'https://www.bbc.com/news')]")
    private WebElement newsMenuItem;

    @FindBy(xpath = "//div[@id = 'orb-nav-links']//a[contains(@href,'https://www.bbc.com/sport')]")
    private WebElement sportMenuItem;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void moveToNewsPage() {
        newsMenuItem.click();
    }

    public void moveToSportPage() {
        sportMenuItem.click();
    }
}
