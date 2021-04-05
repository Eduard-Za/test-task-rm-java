package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage<T extends BasePage<T>> {

    public T open(String url) {
        Selenide.open(url);
        return currentPage();
    }

    @SuppressWarnings("unchecked")
    private T currentPage() {
        return (T) this;
    }

}
