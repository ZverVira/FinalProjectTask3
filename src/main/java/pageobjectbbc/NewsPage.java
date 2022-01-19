package pageobjectbbc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class NewsPage extends BasePage {

    private static final String HEADLINE_ARTICLE_TITLE = "//div[contains(@class,'gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m')]//a[contains(@class,'gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor')]";
    private static final String SECONDARY_ARTICLES_TITLE_LIST = "//h3[@class= 'gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']";
    private static final String HEADLINE_ARTICLE_TITLE_CATEGORY = "//div[contains(@class,'gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-c-promo-body--primary gs-u-mt@xs gs-u-mt@s gs-u-mt@m gs-u-mt@xl gel-1/3@m gel-1/2@xl gel-1/1@xxl')]//a[contains(@class,'gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold gs-u-mt+ nw-o-link-split__anchor')]//h3[@class='gs-c-promo-heading__title gel-paragon-bold gs-u-mt+ nw-o-link-split__text']";
    private static final String CATEGORY_LINK = "//ul[@class='gs-o-list-inline gs-o-list-inline--divided gel-brevier gs-u-mt-']//a[contains(@class,'gs-c-section-link gs-c-section-link--truncate nw-c-section-link nw-o-link nw-o-link--no-visited-state')]";
    private static final String CORONAVIRUS_MENU_ITEM = "//li[@class = 'gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//a[@class = 'nw-o-link'][@href = '/news/coronavirus']";
    private static final String YOUR_CORONAVIRUS_STORIES_MENU_ITEM = "//li[@class = 'gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//a[@class = 'nw-o-link'][@href = '/news/have_your_say']";
    private static final String YOUR_QUESTIONS_ANSWERED = "//a[@href= '/news/52143212']";
    private static final String SEND_US_QUESTION_FORM = "//div[@class= 'embed-content-container']";
    private static final String QUESTION_FIELD = "//div[@class = 'long-text-input-container']";
    private static final String NAME_FIELD = "//input[@aria-label= 'Name']";
    private static final String EMAIL_FIELD = "//input[@aria-label= 'Email address']";
    private static final String TERMS_OF_SERVICE = "//input[@type= 'checkbox']";
    private static final String SUBMIT_BUTTON = "//div[@class= 'embed-content-container']//button[@class = 'button']";
    private static final String ERROR_MESSAGE = "//div[@class= 'input-error-message']";
    private static final String NEWS_PAGE_TITLE = "//div[contains(@class,'nw-c-news-navigation')]";

    Actions action = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadlineArticleTitleText() {
        return driver.findElement(xpath(HEADLINE_ARTICLE_TITLE)).getText();
    }

    public List<WebElement> getSecondaryArticlesTitlesList() {
        return driver.findElements(xpath(SECONDARY_ARTICLES_TITLE_LIST));
    }

    public List<String> addSecondaryArticlesTitlesListIntoStringList() {
        List<String> secondaryArticlesTitlesListText = new ArrayList<>();
        for (WebElement element : getSecondaryArticlesTitlesList()) {
            secondaryArticlesTitlesListText.add(element.getText());
        }
        return secondaryArticlesTitlesListText;
    }

    public void navigateToNewsByCategoryLink() {
        WebElement categoryLink = driver.findElement(xpath(CATEGORY_LINK));
        String categoryLinkText = categoryLink.getAttribute("href");
        driver.navigate().to(categoryLinkText);
    }

    public void clickOnCoronavirusMenuItem() {
        driver.findElement(xpath(CORONAVIRUS_MENU_ITEM)).click();
    }

    public void clickOnYourCoronavirusStoriesMenuItem() {
        driver.findElement(xpath(YOUR_CORONAVIRUS_STORIES_MENU_ITEM)).click();
    }

    public void moveToYourQuestionsAnsweredElement() {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sendUsQuestionLink = driver.findElement(xpath(YOUR_QUESTIONS_ANSWERED));
        js.executeScript("arguments[0].scrollIntoView();", sendUsQuestionLink);
    }

    public void clickOnYourQuestionsAnswered() {
        driver.findElement(xpath(YOUR_QUESTIONS_ANSWERED)).click();
    }

    public void moveToSendUsQuestionForm() {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sendUsQuestionForm = driver.findElement(xpath(SEND_US_QUESTION_FORM));
        js.executeScript("arguments[0].scrollIntoView();", sendUsQuestionForm);
    }

    public void fillQuestionField(String questionText) {
        //Actions action = new Actions(driver);
        WebElement questionField = driver.findElement(xpath(QUESTION_FIELD));
        action.sendKeys(questionField, questionText).build().perform();
    }

    public void fillNameField(String nameText) {
        //Actions action = new Actions(driver);
        WebElement nameField = driver.findElement(xpath(NAME_FIELD));
        action.sendKeys(nameField, nameText).build().perform();
    }

    public void fillEmailField(String emailText) {
        //Actions action = new Actions(driver);
        WebElement emailField = driver.findElement(xpath(EMAIL_FIELD));
        action.sendKeys(emailField, emailText).build().perform();
    }

    public void clickTermsOfServiceCheckbox() {
        driver.findElement(xpath(TERMS_OF_SERVICE)).click();
    }

    public void clickSubmitButton() {
        driver.findElement(xpath(SUBMIT_BUTTON)).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(xpath(ERROR_MESSAGE)).getText();
    }

    public String getNameFieldContent() {
        return driver.findElement(xpath(NAME_FIELD)).getAttribute("value");
    }

    public List<WebElement> getErrorMessagesList() {
        return driver.findElements(xpath(ERROR_MESSAGE));
    }

    public List<String> addErrorMessagesListIntoStringList() {
        List<String> errorMessagesListText = new ArrayList<>();
        for (WebElement element : getErrorMessagesList()) {
            errorMessagesListText.add(element.getText());
        }
        return errorMessagesListText;
    }

    public WebElement getNewsPageTitle() {
        return driver.findElement(xpath(NEWS_PAGE_TITLE));
    }

    public WebElement getHeadlineArticleCategory() {
        return driver.findElement(xpath(HEADLINE_ARTICLE_TITLE_CATEGORY));
    }

    public void clickCoronavirusMenuItem() {
        driver.findElement(xpath(CORONAVIRUS_MENU_ITEM)).click();

    }

    public void clickYourCoronavirusStoriesMenuItem() {
        driver.findElement(xpath(YOUR_CORONAVIRUS_STORIES_MENU_ITEM)).click();

    }

    public void clickSendUsQuestionLink() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sendUsQuestionLink = driver.findElement(xpath(YOUR_QUESTIONS_ANSWERED));
        js.executeScript("arguments[0].scrollIntoView();", sendUsQuestionLink);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.findElement(xpath(YOUR_QUESTIONS_ANSWERED)).click();
    }

//    public void fillSendUsQuestionForm(String questionText, String nameText, String emailText) {
//        Map<String, String> dictionary = new HashMap<String, String>();
//        dictionary.put(QUESTION_FIELD, questionText);
//        dictionary.put(NAME_FIELD, nameText);
//        dictionary.put(EMAIL_FIELD, emailText);
//    }

    public void navigateToSendUsQuestionForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement sendUsQuestionForm = driver.findElement(xpath(SEND_US_QUESTION_FORM));
        js.executeScript("arguments[0].scrollIntoView();", sendUsQuestionForm);
    }

    public void fillSendUsQuestionForm(String question, String name, String email) {
        fillQuestionField(question);
        fillNameField(name);
        fillEmailField(email);
        clickTermsOfServiceCheckbox();
        clickSubmitButton();
    }
}


