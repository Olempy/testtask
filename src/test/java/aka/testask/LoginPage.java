package aka.testask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPage {
    private static final Logger LOG = Logger.getLogger(String.valueOf(LoginPage.class));
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//*[contains(@id, 'id_username')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(@id, 'id_password')]")
    private WebElement passwdField;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[3]/input")
    private WebElement loginBtn;
    @FindBy(xpath = " /html/body/div/div[2]/div[2]/div[1]/div[2]/div/ul[1]/li[1]/ul/li[1]/a")
    private WebElement addBlogEntryBtn;
    @FindBy(xpath = "//*[contains(text(),'Панель управления')]")
    private WebElement controlPanelTitle;
    public void inputLogin(String login) {
        loginField.sendKeys(login); }
    public void inputPassword(String password) {
        passwdField.sendKeys(password); }
    public void clickLoginBtn() {
        loginBtn.click(); }
    public void clickAddBlogEntry() {
        addBlogEntryBtn.click(); }

    public void controlPanelTitleCheck() {

        if (controlPanelTitle.isDisplayed())
        {LOG.info("control panel isn't ok");}
        else
        {LOG.info(" control panel is ok ");}
    }

}


