package pagefactorybbc;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'gs-c-promo-body gs-u-display-none gs-u-display-inline-block@m gs-u-mt@xs gs-u-mt0@m gel-1/3@m')]//a[contains(@class,'gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold nw-o-link-split__anchor')]")
    private WebElement headlineArticleTitle;

    @FindBy(xpath = "//h3[@class= 'gs-c-promo-heading__title gel-pica-bold nw-o-link-split__text']")
    private List<WebElement> secondaryArticleTitleList;

    @FindBy(xpath = "//div[contains(@class,'gs-c-promo-body gs-u-mt@xxs gs-u-mt@m gs-c-promo-body--primary gs-u-mt@xs gs-u-mt@s gs-u-mt@m gs-u-mt@xl gel-1/3@m gel-1/2@xl gel-1/1@xxl')]//a[contains(@class,'gs-c-promo-heading gs-o-faux-block-link__overlay-link gel-paragon-bold gs-u-mt+ nw-o-link-split__anchor')]//h3[@class='gs-c-promo-heading__title gel-paragon-bold gs-u-mt+ nw-o-link-split__text']")
    private WebElement headlineArticleTitleCategory;

    @FindBy(xpath = "//ul[@class='gs-o-list-inline gs-o-list-inline--divided gel-brevier gs-u-mt-']//a[contains(@class,'gs-c-section-link gs-c-section-link--truncate nw-c-section-link nw-o-link nw-o-link--no-visited-state')]")
    private WebElement articleCategoryLink;

    @FindBy(xpath = "//li[@class = 'gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//a[@class = 'nw-o-link'][@href = '/news/coronavirus']")
    private WebElement coronavirusMenuItem;

    @FindBy(xpath = "//li[@class = 'gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//a[@class = 'nw-o-link'][@href = '/news/have_your_say']")
    private WebElement yourCoronavirusStoriesMenuItem;

    @FindBy(xpath = "//a[@href= '/news/52143212']")
    private WebElement sendUsQuestionLink;

    @FindBy(xpath = "//div[@class= 'embed-content-container']")
    private WebElement sendUsQuestionForm;

    @FindBy(xpath = "//div[@class = 'long-text-input-container']")
    private WebElement questionField;

    @FindBy(xpath = "//input[@aria-label= 'Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@aria-label= 'Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type= 'checkbox']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//div[@class= 'embed-content-container']//button[@class = 'button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'input-error-message')]")
    private List<WebElement> errorMessage;

    @FindBy(xpath = "//h1[@id = 'main-heading']")
    private WebElement sendUsQuestionFormHeading;

    private static final long DEFAULT_WAITING_TIME = 60;
    Actions action = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getHeadlineArticleTitleText() {
        return headlineArticleTitle.getText();
    }

    public List<WebElement> getSecondaryArticlesTitlesList() {
        return secondaryArticleTitleList;
    }

    public List<String> addSecondaryArticlesTitlesListIntoStringList() {
        List<String> secondaryArticlesTitlesListText = new ArrayList<>();
        for (WebElement element : getSecondaryArticlesTitlesList()) {
            secondaryArticlesTitlesListText.add(element.getText());
        }
        return secondaryArticlesTitlesListText;
    }

    public void moveToNewsByCategoryLink() {
        WebElement categoryLink = articleCategoryLink;
        String categoryLinkText = categoryLink.getAttribute("href");
        driver.navigate().to(categoryLinkText);
    }

    public WebElement getSendUsQuestionLink() {
        return sendUsQuestionLink;
    }

    public WebElement getSendUsQuestionForm() {
        return sendUsQuestionForm;
    }

    public void fillQuestionField(String questionText) {
        action.sendKeys(questionField, questionText).build().perform();
    }

    public void fillNameField(String nameText) {
        action.sendKeys(nameField, nameText).build().perform();
    }

    public void fillEmailField(String emailText) {
        action.sendKeys(emailField, emailText).build().perform();
    }

    public void clickTermsOfServiceCheckbox() {
        termsOfServiceCheckbox.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getNameFieldContent() {
        return nameField.getAttribute("value");
    }

    public List<WebElement> getErrorMessagesList() {
        return errorMessage;
    }

    public List<String> addErrorMessagesListIntoStringList() {
        List<String> errorMessagesListText = new ArrayList<>();
        for (WebElement element : getErrorMessagesList()) {
            errorMessagesListText.add(element.getText());
        }
        return errorMessagesListText;
    }

    public WebElement getHeadlineArticleCategory() {
        return headlineArticleTitleCategory;
    }

    public void clickCoronavirusMenuItem() {
        coronavirusMenuItem.click();
    }

    public void clickYourCoronavirusStoriesMenuItem() {
        yourCoronavirusStoriesMenuItem.click();
    }

    public void clickSendUsQuestionLink() {
        js.executeScript("arguments[0].scrollIntoView();", getSendUsQuestionLink());
        implicitWait(DEFAULT_WAITING_TIME);
        sendUsQuestionLink.click();
    }

    public void moveToSendUsQuestionForm() {
        js.executeScript("arguments[0].scrollIntoView();", getSendUsQuestionForm());
    }

    public void fillSendUsQuestionForm(String question, String name, String email) {
        fillQuestionField(question);
        fillNameField(name);
        fillEmailField(email);
        clickTermsOfServiceCheckbox();
        clickSubmitButton();
    }

    public WebElement getSendQuestionFormHeading() {
        return sendUsQuestionFormHeading;
    }
}
