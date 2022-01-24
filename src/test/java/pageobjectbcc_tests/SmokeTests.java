package pageobjectbcc_tests;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 60;
    private final String EXPECTED_HEADLINE_ARTICLE_TITLE = "UK withdrawing some embassy staff from Ukraine";
    private final String EXPECTED_HEADLINE_ARTICLE_TITLE_CATEGORY = "UK warns of plot to install Russia ally in Ukraine";
    private final List<String> ACTUAL_SECONDARY_ARTICLES_TITLES = Arrays.asList(
            "Navratilova blasts Peng Shuai T-shirt ban",
            "Fashion designer Thierry Mugler dies aged 73",
            "Man admits abducting Australian girl Cleo Smith",
            "Burkina Faso president detained - reports",
            "Plane stowaway found in Amsterdam survived in wheel",
            "UK PM orders inquiry into 'Muslimness' sacking claim");

    private final String NAME_ERROR_MESSAGE = "Name can't be blank";
    private final String EMAIL_ERROR_MESSAGE = "Email address can't be blank";
    private final String QUESTION_BODY_ERROR_MESSAGE = "can't be blank";
    private final String TERMS_OF_SERVICE_CHECKBOX_ERROR = "must be accepted";
    private final String LONG_NAME_ERROR_MESSAGE = "Name is too long (maximum is 255 characters)";
    private final String LONG_NAME = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
    private final List<String> ERROR_MESSAGES_LIST = Arrays.asList(
            QUESTION_BODY_ERROR_MESSAGE, NAME_ERROR_MESSAGE, EMAIL_ERROR_MESSAGE, TERMS_OF_SERVICE_CHECKBOX_ERROR);


    private final List<String> SEARCHING_CHAMPIONSHIP = Arrays.asList(
            "Scottish Championship",
            "Champions League",
            "Bayern Munich");
    private final List<String> SEARCHING_MONTH = Arrays.asList(
            "2021-12",
            "2021-10",
            "2021-11");
    private final String HOME_TEAM_EXPECTED = "Kilmarnock";
    private final String AWAY_TEAM_EXPECTED = "Greenock Morton";
    private final String HOME_TEAM_SCORE_EXPECTED = "1";
    private final String AWAY_TEAM_SCORE_EXPECTED = "1";
    private final String GAME_SCORE_TEAM = HOME_TEAM_EXPECTED + " " + HOME_TEAM_SCORE_EXPECTED + " " + AWAY_TEAM_SCORE_EXPECTED + " " + AWAY_TEAM_EXPECTED;

    /**
     * Goes to BBC
     * Clicks on News
     * Checks the name of the headline article
     * (the one with the biggest picture and text) against a value specified in your test (hard-coded)
     */

    @Test
    public void checksTheTitleOfTheHeadlineArticle() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        assertEquals(getNewsPage().getHeadlineArticleTitleText(), EXPECTED_HEADLINE_ARTICLE_TITLE);
    }

    /**
     * Goes to BBC
     * Clicks on News
     * Checks secondary article titles (the ones to the right and below the headline article)
     * against a List specified in your test (hard-coded).
     * Imagine that you are testing the BBC site on a test environment, and you know what the titles will be.
     * Your test, then, checks that these titles are in fact present on the page.
     * The test should pass if all the titles are found, and fail if they are not found.
     * It's normal that your test will fail the next day - this would not happen if we had a Test environment for BBC,
     * with a static database.
     */
    @Test
    public void checksTheTitlesOfTheSecondaryArticles() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        assertTrue(getNewsPage().addSecondaryArticlesTitlesListIntoStringList().containsAll(ACTUAL_SECONDARY_ARTICLES_TITLES));
    }

    /**
     * Goes to BBC
     * Clicks on News
     * Stores the text of the Category link of the headline article (e.g. World, Europe...)
     * Enter this text in the Search bar
     * Check the name of the first article against a specified value (hard-coded)
     */
    @Test
    public void checkTheTitleOfHeadlineArticleByCategoryLink() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().moveToNewsByCategoryLink();
        getNewsPage().closeRegisterModalWindow();
        assertEquals(getNewsPage().getHeadlineArticleCategory().getText(), EXPECTED_HEADLINE_ARTICLE_TITLE_CATEGORY);
    }

    /**
     * Add a test which verifies that user can submit a question to BBC:
     * <p>
     * Find a form (several text boxes and possibly check boxes, with some sort of Send/Submit button) that allows you to send a question to BBC. Note that this form sometimes moves around the BBC site - ask in chat if you cannot find it.
     * Below steps work as of 16.09.2020:
     * <p>
     * From BBC Home page go to News;
     * Click on "Coronavirus" tab, and then on "Your Coronavirus Stories" tab;
     * Go to “Coronavirus: Send us your questions”;
     * Scroll down to find the form.
     * <p>
     * <p>
     * Fill the form with information, but one of the required fields empty or with invalid data;
     * Click Send/Submit;
     * Verify that the submission did not work, either by checking for correct error message, or, failing that, that the form still contains entered data.
     * <p>
     * <p>
     * Add at least 2 more tests (use copy-paste). They should do the same as the one we just wrote, except they will cover different negative test cases.
     * Add one case for each required field/checkbox that leaves it empty. If Email is required - add a case where it is invalid.
     */
    @Test
    public void checksThatTheErrorMessagesAboutOutOfSymbolsLimitNameFieldAppearsOnSendUsQuestionForm() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        getNewsPage().clickCoronavirusMenuItem();
        getNewsPage().clickYourCoronavirusStoriesMenuItem();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().clickSendUsQuestionLink();
        getNewsPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getNewsPage().getSendQuestionFormHeading());
        getNewsPage().moveToSendUsQuestionForm();
        getNewsPage().fillSendUsQuestionForm("Test Message", LONG_NAME, "test@test.com");
        getNewsPage().clickTermsOfServiceCheckbox();
        getNewsPage().clickSubmitButton();
        assertTrue(getNewsPage().addErrorMessagesListIntoStringList().contains(LONG_NAME_ERROR_MESSAGE));
    }

    @Test
    public void checksThatTheErrorMessagesAboutEmailFieldCannotBeEmptyAppearsOnSendUsQuestionForm() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        getNewsPage().clickCoronavirusMenuItem();
        getNewsPage().clickYourCoronavirusStoriesMenuItem();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().clickSendUsQuestionLink();
        getNewsPage().moveToSendUsQuestionForm();
        getNewsPage().fillSendUsQuestionForm("Test Message", "Test Name", "");
        getNewsPage().clickTermsOfServiceCheckbox();
        getNewsPage().clickSubmitButton();
        assertTrue(getNewsPage().addErrorMessagesListIntoStringList().contains(EMAIL_ERROR_MESSAGE));
    }

    @Test
    public void checksThatTheNameFieldContentIsNotEmptyAfterClickingOnSubmitButtonInCaseOfError() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        getNewsPage().clickCoronavirusMenuItem();
        getNewsPage().clickYourCoronavirusStoriesMenuItem();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().clickSendUsQuestionLink();
        getNewsPage().moveToSendUsQuestionForm();
        getNewsPage().fillSendUsQuestionForm("Test Message", LONG_NAME, "test@test.com");
        getNewsPage().clickTermsOfServiceCheckbox();
        getNewsPage().clickSubmitButton();
        assertFalse(getNewsPage().getNameFieldContent().isEmpty());
    }

    @Test
    public void checksThatTheAllErrorMessagesAppearsIfAllRequiredFieldsAreNotFilledOnSendUsQuestionForm() {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        getNewsPage().clickCoronavirusMenuItem();
        getNewsPage().clickYourCoronavirusStoriesMenuItem();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().clickSendUsQuestionLink();
        getNewsPage().moveToSendUsQuestionForm();
        getNewsPage().clickSubmitButton();
        assertTrue(getNewsPage().addErrorMessagesListIntoStringList().containsAll(ERROR_MESSAGES_LIST));
    }

    /**
     * BBC 2
     */

    @Test
    public void verifyThatTeamScoresDisplayCorrectlyScottishChampionship() {
        getHomePage().moveToSportPage();
        getSportPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSportPage().clickFootballMenuItem();
        getSportPage().clickScoresAndFixturesMenuItem();
        getSportPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSportPage().getChampionshipSearchField());
        getSportPage().chooseChampionShip(SEARCHING_CHAMPIONSHIP.get(0));
        getSportPage().chooseMonthOfChampionship(SEARCHING_MONTH.get(0));
        getSportPage().waitClickableOfElement(DEFAULT_WAITING_TIME, getSportPage().getShowScorersButton());
        getSportPage().moveToGameFromTheList();
        assertEquals(getSportPage().getHomeTeamActual() + " " + getSportPage().getHomeTeamScoreActual() + " " + getSportPage().getAwayTeamScoreActual() + " " + getSportPage().getAwayTeamActual(), GAME_SCORE_TEAM);
    }

    @Test
    public void verifyThatTeamScoresDisplayCorrectlyOnTeamPageForScottishChampionship() {
        getHomePage().moveToSportPage();
        getSportPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSportPage().clickFootballMenuItem();
        getSportPage().clickScoresAndFixturesMenuItem();
        getSportPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSportPage().getChampionshipSearchField());
        getSportPage().chooseChampionShip(SEARCHING_CHAMPIONSHIP.get(0));
        getSportPage().chooseMonthOfChampionship(SEARCHING_MONTH.get(0));
        getSportPage().waitClickableOfElement(DEFAULT_WAITING_TIME, getSportPage().getShowScorersButton());
        getSportPage().moveToGameFromTheList();
        String gameResultOnChampionshipPage = getSportPage().getChampionshipGameResult();
        getSportPage().navigateToGameDetailPage();
        getGamePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getGamePage().getGamePageHeader());
        assertEquals(getGamePage().getHomeTeamActual() + " " + getGamePage().getHomeTeamScoreActual() + " " + getGamePage().getAwayTeamScoreActual() + " " + getGamePage().getAwayTeamActual(), gameResultOnChampionshipPage);
    }


    /**
     * Add 4 more tests (use copy-paste). They should all do the same thing with different data (championship, month, teams, score).
     */

    @Test
    public void verifyThatTeamScoresDisplayCorrectlyOnTeamPageForChampionsLeague() {
        getHomePage().moveToSportPage();
        getSportPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSportPage().clickFootballMenuItem();
        getSportPage().clickScoresAndFixturesMenuItem();
        getSportPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSportPage().getChampionshipSearchField());
        getSportPage().chooseChampionShip(SEARCHING_CHAMPIONSHIP.get(1));
        getSportPage().chooseMonthOfChampionship(SEARCHING_MONTH.get(1));
        getSportPage().waitClickableOfElement(DEFAULT_WAITING_TIME, getSportPage().getShowScorersButton());
        getSportPage().moveToGameFromTheList();
        String gameResultOnChampionshipPage = getSportPage().getChampionshipGameResult();
        getSportPage().navigateToGameDetailPage();
        getGamePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getGamePage().getGamePageHeader());
        assertEquals(getGamePage().getHomeTeamActual() + " " + getGamePage().getHomeTeamScoreActual() + " " + getGamePage().getAwayTeamScoreActual() + " " + getGamePage().getAwayTeamActual(), gameResultOnChampionshipPage);
    }

    @Test
    public void verifyThatTeamScoresDisplayCorrectlyOnTeamPageForBayernMunich() {
        getHomePage().moveToSportPage();
        getSportPage().waitForPageLoadComplete(DEFAULT_WAITING_TIME);
        getSportPage().clickFootballMenuItem();
        getSportPage().clickScoresAndFixturesMenuItem();
        getSportPage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getSportPage().getChampionshipSearchField());
        getSportPage().chooseChampionShip(SEARCHING_CHAMPIONSHIP.get(2));
        getSportPage().chooseMonthOfChampionship(SEARCHING_MONTH.get(2));
        getSportPage().waitClickableOfElement(DEFAULT_WAITING_TIME, getSportPage().getShowScorersButton());
        getSportPage().moveToGameFromTheList();
        String gameResultOnChampionshipPage = getSportPage().getChampionshipGameResult();
        getSportPage().navigateToGameDetailPage();
        getGamePage().waitVisibilityOfElement(DEFAULT_WAITING_TIME, getGamePage().getGamePageHeader());
        assertEquals(getGamePage().getHomeTeamActual() + " " + getGamePage().getHomeTeamScoreActual() + " " + getGamePage().getAwayTeamScoreActual() + " " + getGamePage().getAwayTeamActual(), gameResultOnChampionshipPage);
    }
}
