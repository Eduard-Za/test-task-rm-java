import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {

    @BeforeSuite
    public static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true));
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.startMaximized = true;
    }

    @AfterMethod
    public void afterEach() {
        Selenide.closeWebDriver();
    }
}
