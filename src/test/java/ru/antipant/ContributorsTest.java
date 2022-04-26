package ru.antipant;

import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    @Test
    void solntsevShouldBeFirstContributors(){

        // open repository page
        open("https://github.com/selenide/selenide");

        //bring mouse over the first avatar on contributors tab
        $(".Layout-sidebar").$(byText("Contributors")).ancestor("div")
                .$$("ul li").first().hover();

        //check: popup is showing andrey solntsev
        $$(".Popover-message").filterBy(visible).first().shouldHave(text("Andrei Solntsev"));
    }

}
