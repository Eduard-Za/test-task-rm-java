import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import data.DataProviders;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataProviders.class)
    public void loginWithInvalidCredentials(String email, String password, List<String> errorMessages) {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .login(email, password, loginPage)
                .getErrorMessagesFromTopOfTheLoginModal()
                .shouldHave(CollectionCondition.texts(errorMessages));

        loginPage.getErrorMessagesFromRightOfTheLoginModal()
                .shouldHave(CollectionCondition.texts(errorMessages));
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = DataProviders.class)
    public void loginWithValidCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage
                .open()
                .login(email, password, new HomePage());
        homePage.getUserBalanceSection().shouldBe(Condition.visible);
    }


    @Test
    public void loginAsGuest(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.open().acceptCookies().loginAsGuest();
        homePage.getAttentionMessage().shouldHave(Condition.text("Attention! You're not logged in!"));
    }



}


