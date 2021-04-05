package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage extends BasePage<LoginPage> {


    private String modalLoginSelector = ".modal-window__frame";
    private String loginBtnSelector = ".button_type_brand";
    private String emailFieldSelector = ".input__field_mode_email";
    private String passwordFieldSelector = ".password__field_mode_password";
    private String errorMessagesFromTopSelector = ".tooltip_pos_top .err__txt:not(:empty)";
    private String errorMessageFromRightSelector = ".tooltip_pos_right .err:not(:empty)";
    private String loginAsGuestSelector = "#Without_Registration_Link";
    private String acceptCookiesSelector = "#AllowCookies_Allow_ViewButton";
    private String registrationBtnSelector = ".button_type_quick-demo";


    public LoginPage open() {
        return open("https://webtrader.roboforex.com/");
    }

    public ElementsCollection getErrorMessagesFromTopOfTheLoginModal() {
        return $$(this.errorMessagesFromTopSelector);
    }

    public ElementsCollection getErrorMessagesFromRightOfTheLoginModal() {
        return $$(this.errorMessageFromRightSelector);
    }

    public <T extends BasePage> T login(String email, String password, T page) {
        $(this.emailFieldSelector).shouldBe(Condition.visible).setValue(email);
        $(this.passwordFieldSelector).setValue(password);
        $(this.loginBtnSelector).click();
        return page;
    }

    public LoginPage acceptCookies() {
        $(acceptCookiesSelector).shouldBe(Condition.visible).click();
        return this;
    }

    public RegistrationPage transferToRegistrationPage() {
        $(registrationBtnSelector).shouldBe(Condition.enabled).click();
        return new RegistrationPage();
    }

    public HomePage loginAsGuest() {
        $(loginAsGuestSelector).shouldBe(Condition.enabled).click();
        return new HomePage();
    }

}




