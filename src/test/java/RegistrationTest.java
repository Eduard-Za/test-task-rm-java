import com.codeborne.selenide.Condition;
import data.DataProviders;
import org.testng.annotations.Test;
import pages.LoginPage;

public class RegistrationTest extends BaseTest {

    @Test(dataProvider = "registrationData", dataProviderClass = DataProviders.class)
    public void registrationTest(String email, String firstName, String lastName, String phone) {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .transferToRegistrationPage()
                .setRegistrationDataAndProceed(email, firstName, lastName, phone)
                .getAccountDetailsInfo().shouldHave(Condition
                .text("Members Area and Demo Account have been created. All the info was sent to " +
                        email + "."));
    }
}
