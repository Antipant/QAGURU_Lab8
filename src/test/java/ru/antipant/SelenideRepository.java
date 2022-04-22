package ru.antipant;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @Test
    void shouldFindSelenideAsFirstRepository() {
        // открыть страницу github.com
        open("https://github.com");

        // ввести в поле поиска selenide и нажать enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();

        // проверяем
        $("h2").shouldHave(text("selenide / selenide"));
    }

}
