package pageobjectbcc_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {

    private static final long DEFAULT_WAITING_TIME = 60;
    private String EXPECTED_HEADLINE_ARTICLE_TITLE = "Tonga undersea cable may take four weeks to repair";
    private List<String> ACTUAL_SECONDARY_ARTICLES_TITLES = Arrays.asList(
            "US urges Putin to take peaceful path on Ukraine",
            "'World's most valuable house' - which no one wanted to buy",
            "Former Vogue creative director Talley dies aged 73",
            "Britney issues cease and desist letter to sister",
            "Militant jailed for masterminding Bali bombings");

    private String NAME_ERROR_MESSAGE = "Name can't be blank";
    private String EMAIL_ERROR_MESSAGE = "Email address can't be blank";
    private String QUESTION_BODY_ERROR_MESSAGE = "can't be blank";
    private String TERMS_OF_SERVICE_CHECKBOX_ERROR = "must be accepted";
    private String LONG_NAME_ERROR_MESSAGE = "Name is too long (maximum is 255 characters)";
    private String LONG_NAME = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
    private List<String> ERROR_MESSAGES_LIST = Arrays.asList(
            QUESTION_BODY_ERROR_MESSAGE, NAME_ERROR_MESSAGE, EMAIL_ERROR_MESSAGE, TERMS_OF_SERVICE_CHECKBOX_ERROR);

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
        assertEquals(getNewsPage().addSecondaryArticlesTitlesListIntoStringList().subList(0, 5), ACTUAL_SECONDARY_ARTICLES_TITLES);

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
        getNewsPage().navigateToNewsByCategoryLink();
        getNewsPage().closeRegisterModalWindow();
        assertEquals(getNewsPage().getHeadlineArticleCategory().getText(), EXPECTED_HEADLINE_ARTICLE_TITLE);
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
    public void checksThatTheErrorMessagesAboutOutOfSymbolsLimitNameFieldAppearsOnSendUsQuestionForm() throws InterruptedException {
        getHomePage().moveToNewsPage();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().closeRegisterModalWindow();
        getNewsPage().clickOnCoronavirusMenuItem();
        getNewsPage().clickYourCoronavirusStoriesMenuItem();
        getNewsPage().moveToYourQuestionsAnsweredElement();
        getNewsPage().implicitWait(DEFAULT_WAITING_TIME);
        getNewsPage().clickOnYourQuestionsAnswered();
        getNewsPage().navigateToSendUsQuestionForm();
        getNewsPage().fillSendUsQuestionForm("Test Message",LONG_NAME,"test@test.com");
        getNewsPage().clickTermsOfServiceCheckbox();
        getNewsPage().clickSubmitButton();
        assertEquals(getNewsPage().getErrorMessageText(), LONG_NAME_ERROR_MESSAGE);
    }
}
