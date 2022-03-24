package aka.testask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class AdminBlogPage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(AdminBlogPage.class));
    public WebDriver driver;
        public AdminBlogPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
            this.driver = driver; }
    public String str2;
    public void getLast( String Str) {
     str2 =Str ;
     LOG.info( "string is " + str2);}
    @FindBy(xpath = "//*[@id=\"module_2\"]/div/ul/li[contains(text(),str2)]/a")
    private WebElement lookingForRecentTitle;
    @FindBy(xpath = "//*[@id=\"entry_form\"]/div/div/p")
    private WebElement deleteBtn;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/input[2]")
    private WebElement confirmDeleteBtn;

    public void clickGoToRecentTitle( ) {
        if (lookingForRecentTitle.isDisplayed()){
        lookingForRecentTitle.click();}
        else
        {LOG.info("entry not exist!");}
 }
    public void clickDeleteBtn() {
        deleteBtn.click();}
    public void clickConfirmDeleteBtn() {
            confirmDeleteBtn.click();}
}



