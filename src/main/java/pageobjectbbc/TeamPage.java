package pageobjectbbc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamPage extends BasePage {

    private static final String HOME_TEAM_NAME_TEAM_PAGE = "//span[contains(@data-reactid,'0.0.1.0.0.0.0.1')]";
    private static final String AWAY_TEAM_NAME_TEAM_PAGE = "//span[contains(@data-reactid,'0.0.1.0.2.0.0.1')]";
    private static final String HOME_TEAM_SCORE_TEAM_PAGE = "//span[contains(@data-reactid,'0.0.1.0.0.1.0')]";
    private static final String AWAY_TEAM_SCORE_TEAM_PAGE = "//span[contains(@data-reactid,'0.0.1.0.2.1.0')]";


    public TeamPage(WebDriver driver) {
        super(driver);
    }

    public String getHomeTeamActual() {
        return driver.findElement(By.xpath(HOME_TEAM_NAME_TEAM_PAGE)).getText();
    }

    public String getAwayTeamActual() {
        return driver.findElement(By.xpath(AWAY_TEAM_NAME_TEAM_PAGE)).getText();
    }

    public String getHomeTeamScoreActual() {
        return driver.findElement(By.xpath(HOME_TEAM_SCORE_TEAM_PAGE)).getText();
    }

    public String getAwayTeamScoreActual() {
        return driver.findElement(By.xpath(AWAY_TEAM_SCORE_TEAM_PAGE)).getText();
    }
}
