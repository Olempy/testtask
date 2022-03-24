package aka.testask;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    //Хром
    public static LoginPage loginPage;
    public static AdminBlogEntryAddPage adminBlogEntryAddPage;
    public static AdminBlogPage adminBlogPage;
    public static WebDriver driver;
    //Мозилла
    /*public static LoginPage loginPage2;
    public static AdminBlogEntryAddPage adminBlogEntryAddPage2;
    public static AdminBlogPage adminBlogPage2;
    public static WebDriver driver2;*/

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        adminBlogEntryAddPage = new AdminBlogEntryAddPage(driver);
        adminBlogPage = new AdminBlogPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
}

    @Test
    public void loginTest() {

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        loginPage.controlPanelTitleCheck();
        loginPage.clickAddBlogEntry();

        adminBlogEntryAddPage.addEntryTitleCheck();
        String Str = adminBlogEntryAddPage.getTextForTitleField();
        adminBlogEntryAddPage.getTextForSlugField();
        adminBlogEntryAddPage.getTextForTextMarkdownField();
        adminBlogEntryAddPage.getTextForTextField();
        adminBlogEntryAddPage.clickSaveBtn();
        adminBlogEntryAddPage.clickGoToBlog();
        adminBlogPage.getLast(Str);
        adminBlogPage.clickGoToRecentTitle();
        adminBlogPage.clickDeleteBtn();
        adminBlogPage.clickConfirmDeleteBtn();
    }
/*
    @Before
    public  void setup2() {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver.exe");
        WebDriver driver2 = new FirefoxDriver();
        loginPage2 = new LoginPage(driver);
        adminBlogEntryAddPage2 = new AdminBlogEntryAddPage(driver);
        adminBlogPage2 = new AdminBlogPage(driver);
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest2() {

        loginPage2.inputLogin(ConfProperties.getProperty("login"));
        loginPage2.inputPassword(ConfProperties.getProperty("password"));
        loginPage2.clickLoginBtn();
        loginPage2.controlPanelTitleCheck();
        loginPage2.clickAddBlogEntry();

        adminBlogEntryAddPage2.addEntryTitleCheck();
        String Str = adminBlogEntryAddPage2.getTextForTitleField();
        adminBlogEntryAddPage2.getTextForSlugField();
        adminBlogEntryAddPage2.getTextForTextMarkdownField();
        adminBlogEntryAddPage2.getTextForTextField();
        adminBlogEntryAddPage2.clickSaveBtn();
        adminBlogEntryAddPage2.clickGoToBlog();
        adminBlogPage2.getLast(Str);
        adminBlogPage2.clickGoToRecentTitle();
        adminBlogPage2.clickDeleteBtn();
        adminBlogPage2.clickConfirmDeleteBtn();
    }
*/
}

