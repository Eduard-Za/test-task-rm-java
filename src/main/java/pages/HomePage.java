package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage<HomePage> {
    private String userAccountDataSelector = "#account-selector";
    private String attentionMessageForGuestsSelector = ".important";

    public SelenideElement getUserBalanceSection() {
        $(userAccountDataSelector).shouldBe(Condition.visible);
        return $(userAccountDataSelector);
    }

    public SelenideElement getAttentionMessage() {
        return $(attentionMessageForGuestsSelector);
    }
}

