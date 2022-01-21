package pagefactorybbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class SportPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'sp-c-sport-navigation__item ')]//a[contains(@data-stat-title,'Football')]")
    private WebElement footballMenuItem;

    @FindBy(xpath = "//li[contains(@class,'sp-c-sport-navigation__item ')]//a[contains(@data-stat-title,'Scores & Fixtures')]")
    private WebElement scoresFixturesMenuItem;

    @FindBy(xpath = "//input[contains(@id,'downshift-0-input')]")
    private WebElement championshipSearchField;

    @FindBy(xpath = "//a[contains(@class,'sp-c-search__result-item')]")
    private WebElement championshipMenuItem;

    @FindBy(xpath = "//li[@class='sp-c-date-picker-timeline__item']//a[contains(@href,'scores-fixtures/2021-12')]")
    private WebElement championshipMonth;

    @FindBy(xpath = "//span[contains(@data-reactid,'-wrapper.0.0.0.0.0.0.1')]")
    private List<WebElement> homeTeamName;

    @FindBy(xpath = "//span[contains(@data-reactid,'-wrapper.0.0.0.2.0.0.1')]")
    private List<WebElement> awayTeamName;

    @FindBy(xpath = "//span[contains(@data-reactid,'-wrapper.0.0.0.0.1.0')]")
    private List<WebElement> homeTeamScore;

    @FindBy(xpath = "//span[contains(@data-reactid,'-wrapper.0.0.0.2.1.0')]")
    private List<WebElement> awayTeamScore;

    @FindBy(xpath = "//a[@class = 'sp-c-fixture__block-link']")
    private List<WebElement> gameFromList;

    @FindBy(xpath = "//button[@class = 'gel-pica-bold qa-show-scorers-button sp-c-football-scores-button sp-c-football-scores-button--show-scorers']")
    private WebElement showScorersButton;

    Actions action = new Actions(driver);

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickFootballMenuItem() {
        footballMenuItem.click();
    }

    public void clickScoresAndFixturesMenuItem() {
        scoresFixturesMenuItem.click();
    }

    public WebElement getChampionshipMenuItem() {
        return championshipMenuItem;
    }

    public void chooseChampionShip(String searchingChampionship) {
        action.sendKeys(getChampionshipSearchField(), searchingChampionship).build().perform();
        action.moveToElement(getChampionshipMenuItem()).click().build().perform();
    }

    public void chooseMonthOfChampionship() {
        championshipMonth.click();
    }

    public String getHomeTeamActual() {
        return getHomeTeamList().get(0).getText();
    }

    public String getAwayTeamActual() {
        return getAwayTeamList().get(0).getText();
    }

    public String getHomeTeamScoreActual() {
        return getHomeTeamScoreList().get(0).getText();
    }

    public String getAwayTeamScoreActual() {
        return getAwayTeamScoreList().get(0).getText();
    }

    public WebElement getChampionshipSearchField() {
        return championshipSearchField;
    }

    public List<WebElement> getGameList() {
        return gameFromList;
    }

    public void moveToGameFromTheList() {
        action.moveToElement(getGameList().get(0));
    }

    public void navigateToGameDetailPage() {
        getGameList().get(0).click();
    }

    public WebElement getShowScorersButton() {
        return showScorersButton;
    }

    public String getChampionshipGameResult() {
        return getHomeTeamActual() + " " + getHomeTeamScoreActual() + " " + getAwayTeamScoreActual() + " " + getAwayTeamActual();
    }

    public List<WebElement> getHomeTeamList() {
        return homeTeamName;
    }

    public List<WebElement> getHomeTeamScoreList() {
        return homeTeamScore;
    }

    public List<WebElement> getAwayTeamList() {
        return awayTeamName;
    }

    public List<WebElement> getAwayTeamScoreList() {
        return awayTeamScore;
    }
}
