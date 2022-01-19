package pageobjectbbc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class SportPage extends BasePage {

    private static final String FOOTBALL_MENU_ITEM = "//li[contains(@class,'sp-c-sport-navigation__item ')]//a[contains(@data-stat-title,'Football')]";
    private static final String SCORES_FIXTURES_MENU_ITEM = "//li[contains(@class,'sp-c-sport-navigation__item ')]//a[contains(@data-stat-title,'Scores & Fixtures')]";
    private static final String CHAMPIONSHIP_SEARCH_FIELD = "//input[contains(@id,'downshift-0-input')]";
    private static final String CHAMPIONSHIP_MENU_ITEM = "//a[contains(@class,'sp-c-search__result-item')]";
    //private static final String SEARCH_MONTH = "2021-12";
    //private static final String CHAMPIONSHIP_MONTH = "//li[@class='sp-c-date-picker-timeline__item']//a[contains(@href,'scores-fixtures/" + SEARCH_MONTH + "')]";
    private static final String CHAMPIONSHIP_MONTH = "//li[@class='sp-c-date-picker-timeline__item']//a[contains(@href,'scores-fixtures/";
    private static final String KILMARNOCK_TEAM_LINK = "//article[@class = 'sp-c-fixture'][@data-event-id = 'EFBO2209365']";
    private static final String HOME_TEAM_NAME = "//span[@class= 'gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc'][contains(@data-reactid,'2.0.0.2.0.$0Scottish ChampionshipWednesday-29th-December.2.$EFBO2209365-wrapper.0.0.0.0.0.0.1')]";
    private static final String AWAY_TEAM_NAME = "//span[@class = 'gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc'][contains(@data-reactid,'2.0.0.2.0.$0Scottish ChampionshipWednesday-29th-December.2.$EFBO2209365-wrapper.0.0.0.2.0.0.1')]";
    private static final String HOME_TEAM_SCORE = "//span[@class= 'sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft'][contains(@data-reactid,'2.0.0.2.0.$0Scottish ChampionshipWednesday-29th-December.2.$EFBO2209365-wrapper.0.0.0.0.1.0')]";
    private static final String AWAY_TEAM_SCORE = "//li[@class = 'gs-o-list-ui__item gs-u-pb-']//span[contains(@data-reactid,'2.0.0.2.0.$0Scottish ChampionshipWednesday-29th-December.2.$EFBO2209365-wrapper.0.0.0.2.1.0')]";


    public SportPage(WebDriver driver) {
        super(driver);
    }

    public void clickFootballMenuItem() {
        driver.findElement(xpath(FOOTBALL_MENU_ITEM)).click();
    }

    public void clickScoresAndFixturesMenuItem() {
        driver.findElement(xpath(SCORES_FIXTURES_MENU_ITEM)).click();
    }

    public void chooseChampionShip(String searchingChampionship) {
        Actions action = new Actions(driver);
        WebElement searchField = driver.findElement(xpath(CHAMPIONSHIP_SEARCH_FIELD));
        action.sendKeys(searchField, searchingChampionship).build().perform();
        WebElement championshipMenuItem = driver.findElement(xpath(CHAMPIONSHIP_MENU_ITEM));
        action.moveToElement(championshipMenuItem).click().build().perform();
    }

    public void chooseMonthOfChampionship(String yearMonth) {
        driver.findElement(By.xpath(CHAMPIONSHIP_MONTH)).click();
    }

    public void moveToTeamDetailsPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(KILMARNOCK_TEAM_LINK));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public String addDateParameterToXpath(String date) {
        return CHAMPIONSHIP_MONTH + date + "')]";
    }

    public String getHomeTeamActual() {
        return driver.findElement(By.xpath(HOME_TEAM_NAME)).getText();
    }

    public String getAwayTeamActual() {
        return driver.findElement(By.xpath(AWAY_TEAM_NAME)).getText();
    }

    public String getHomeTeamScoreActual() {
        return driver.findElement(By.xpath(HOME_TEAM_SCORE)).getText();
    }

    public String getAwayTeamScoreActual() {
        return driver.findElement(By.xpath(AWAY_TEAM_SCORE)).getText();
    }
//        String searchingChampionship = "Champions League";
//        String searchingMonth = "2021-10";
//        article[@class = 'sp-c-fixture'][@data-event-id = 'EFBO2244617'
//        String homeTeamActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueWednesday-20th-October.2.$EFBO2244617-wrapper.0.0.0.0.0.0.1')]"));
//        String awayTeamActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueWednesday-20th-October.2.$EFBO2244617-wrapper.0.0.0.2.0.0.1')]"));
//        String homeTeamScoreActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueWednesday-20th-October.2.$EFBO2244617-wrapper.0.0.0.0.1.0')]"));
//        String awayTeamScoreActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueWednesday-20th-October.2.$EFBO2244617-wrapper.0.0.0.2.1.0')]"));
//        driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueWednesday-20th-October.2.$EFBO2244617-wrapper.0.0.0.0.0.0.1')]")).click();
//        String homeTeamActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.0.0.0.1')]")).getText();
//        String awayTeamActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.2.0.0.1')]")).getText();
//        String homeTeamScoreActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.0.1.0')]")).getText();
//        String awayTeamScoreActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.2.1.0')]")).getText();


//        String searchingChampionship = "Bayern Munich";
//        String searchingMonth = "2021-11";
//        Actions action = new Actions(driver);
//        WebElement element = driver.findElement(By.xpath("//article[@class = 'sp-c-fixture'][@data-event-id = 'EFBO2244635']"));
//        String homeTeamActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueTuesday-2nd-November.2.$EFBO2244635-wrapper.0.0.0.0.0.0.1')]")).getText();
//        String awayTeamActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueTuesday-2nd-November.2.$EFBO2244635-wrapper.0.0.0.2.0.0.1')]")).getText();
//        String homeTeamScoreActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueTuesday-2nd-November.2.$EFBO2244635-wrapper.0.0.0.0.1.0')]")).getText();
//        String awayTeamScoreActual = driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueTuesday-2nd-November.2.$EFBO2244635-wrapper.0.0.0.2.1.0')]")).getText();
//        driver.findElement(By.xpath("//span[contains(@data-reactid,'2.0.0.2.0.$0Champions LeagueTuesday-2nd-November.2.$EFBO2244635-wrapper.0.0.0.0.0.0.1')]")).click();
//        String homeTeamActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.0.0.0.1')]")).getText();
//        String awayTeamActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.2.0.0.1')]")).getText();
//        String homeTeamScoreActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.0.1.0')]")).getText();
//        String awayTeamScoreActualTeamPage = driver.findElement(By.xpath("//span[contains(@data-reactid,'0.0.1.0.2.1.0')]")).getText();
//

}
