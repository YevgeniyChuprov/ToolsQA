package pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Dropdown {

    public void setDropDawn(String value){
        $("#stateCity-wrapper").$(byText(value)).click();
    }
}
