package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DemoAccountDetailsModal extends BasePage<HomePage> {

    private String accountDetailsInfo = ".demo-account-details__description";

    public SelenideElement getAccountDetailsInfo() {
        return $(accountDetailsInfo).shouldBe(Condition.visible);
    }
}



