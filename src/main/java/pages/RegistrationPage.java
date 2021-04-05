package pages;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage<RegistrationPage> {


    private String emailFieldSelector = ".input__field_mode_email";
    private String phoneFieldSelector = ".quick-demo-acc-form__phone input";
    private String firstNameFieldSelector = ".quick-demo-acc-form__name input";
    private String lastNameFieldSelector = ".quick-demo-acc-form__surname input";
    private String registrationBtnSelector = ".quick-demo-acc-form__button .button";

    public DemoAccountDetailsModal setRegistrationDataAndProceed(String email, String firstName, String lastName, String phone) {
        $(emailFieldSelector).setValue(email);
        $(firstNameFieldSelector).setValue(firstName);
        $(lastNameFieldSelector).setValue(lastName);
        $(phoneFieldSelector).setValue(phone);
        $(registrationBtnSelector).click();
        return new DemoAccountDetailsModal();
    }
}



