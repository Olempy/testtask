package aka.testask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;
import java.util.logging.Logger;

public class AdminBlogEntryAddPage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(AdminBlogEntryAddPage.class));
    public static String Str;

    public WebDriver driver;
        public AdminBlogEntryAddPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver; }

    @FindBy(xpath = "//*[contains(@id, 'id_title')]")
    private WebElement titleField;
    @FindBy(xpath = "//*[contains(@id, 'id_slug')]")
    private WebElement slugField;
    @FindBy(xpath = "//*[contains(@id, 'id_text_markdown')]")
    private WebElement textMarkdownField;
    @FindBy(xpath = "//*[@id=\"id_text\"]")
    private WebElement textField;
    @FindBy(xpath = "  //*[@id=\"entry_form\"]/div/div/input[1]")
    private WebElement saveBtn;
    @FindBy(xpath = " //*[@id=\"container\"]/div[2]/a[2]")
    private WebElement goToBlogBtn;
    @FindBy(xpath = "//*[contains(text(),'Добавить entry')]")
    private WebElement addEntryTitle;
    final Random random = new Random();
    String randomLong = String.valueOf(random.nextLong());
    public String getTextForTitleField() {
        String textForTitleField = "Title"+ randomLong;
        titleField.sendKeys(textForTitleField);
        Str = textForTitleField;
    return textForTitleField;}

    public void getTextForSlugField() {
        String textForSlugField = "Slug"+ randomLong;
        slugField.clear();
        slugField.sendKeys(textForSlugField);  }
    public void getTextForTextMarkdownField() {
        String textForTextMarkdownField = "Slug"+ randomLong;
        textMarkdownField.sendKeys(textForTextMarkdownField);  }
    public void getTextForTextField() {
        String textForTextField = "Slug"+ randomLong;
        textField.sendKeys(textForTextField);  }
    public void clickSaveBtn() {
        saveBtn.click(); }
    public void clickGoToBlog() {
       goToBlogBtn.click(); }
    public void addEntryTitleCheck() {
        if (addEntryTitle.isDisplayed())
        {LOG.info("add entry title isn't ok");}
        else
        {LOG.info("add entry title is ok ");}
    }
}

