package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalForm {
    @Step("Check header modal form")
    public ModalForm checkHeaderModalForm(String str){
        $("#example-modal-sizes-title-lg").shouldHave(text(str));
        return this;
    }
    @Step("Check modal form {value}")
    public ModalForm checkModalForm(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
