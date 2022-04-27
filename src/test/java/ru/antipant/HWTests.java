package ru.antipant;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HWTests {

    @Test
    void softAssertionsTest(){
        // open repository page
        open("https://github.com/selenide/selenide");

        // open wikiTab
        $("#wiki-tab").click();

        // have text right bar
        $("li.wiki-more-pages-link").$("button").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        // open page softAssertions
        $(".markdown-body").$(byText("Soft assertions")).click();

        // have text
        $(".markdown-body").$("#user-content-3-using-junit5-extend-test-class").parent()
                .shouldHave(text("Using JUnit5 extend test class"));
    }

    @Test
    void dragAndDropTest() {
        //open page
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // drag and drop
        $("#column-a").dragAndDropTo($("#column-b"));
        // actions().dragAndDrop($("#column-a"),$("#column-b")).perform(); not work

        // drag and drop success
        $("#column-b").shouldHave(text("A"));
    }

    // При поиске по селектору $("h1 div") будет искать первый элемент по "h1 div"
    // При поиске по селектору $("h1").$("div") будет искать первый элемент "h1", у которого внутри есть элемент "div"
    // Это могут быть разные элементы

}
