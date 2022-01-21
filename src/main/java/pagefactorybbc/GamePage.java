package pagefactorybbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class GamePage extends BasePage{

    @FindBy(xpath = "//span[contains(@data-reactid,'0.0.1.0.0.0.0.1')]")
    private WebElement homeTeamNameGamePage;

    @FindBy(xpath = "//span[contains(@data-reactid,'0.0.1.0.2.0.0.1')]")
    private WebElement awayTeamNameGamePage;

    @FindBy(xpath = "//span[contains(@data-reactid,'0.0.1.0.0.1.0')]")
    private WebElement homeTeamScoreGamePage;

    @FindBy(xpath = "//span[contains(@data-reactid,'0.0.1.0.2.1.0')]")
    private WebElement awayTeamScoreGamePage;

    @FindBy(xpath = "//div[contains(@class, 'event-header sp-c-match-overview-header sp-c-match-overview-header--football')]")
    private WebElement gamePageHeader;

    public GamePage(WebDriver driver) {
        super(driver);
    }

    public String getHomeTeamActual() { return homeTeamNameGamePage.getText(); }

    public String getAwayTeamActual() {
        return awayTeamNameGamePage.getText();
    }

    public String getHomeTeamScoreActual() {
        return homeTeamScoreGamePage.getText();
    }

    public String getAwayTeamScoreActual() {
        return awayTeamScoreGamePage.getText();
    }

    public WebElement getGamePageHeader() {
        return gamePageHeader;
    }
}
