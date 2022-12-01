package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalForm {

    public ModalForm checkHeaderModalForm(String str){
        $("#example-modal-sizes-title-lg").shouldHave(text(str));
        return this;
    }

    public ModalForm setModalForm(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
