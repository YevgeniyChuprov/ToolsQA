package pages;

import io.qameta.allure.Step;

import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PersonalData {
    @Step("Entering a firstname {firstName}")
    public PersonalData setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }
    @Step("Entering a lastname {lastName}")
    public PersonalData setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }
    @Step("Entering a mail {userEmail}")
    public PersonalData setUserEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
        return this;
    }
    @Step("Check gender {genderWrapper}")
    public PersonalData setGenderWrapper(String genderWrapper){
        $("#genterWrapper").$(byText(genderWrapper)).click();
        return this;
    }
    @Step("Entering a phone number {userNumber}")
    public PersonalData setUserNumber(String userNumber){
        $("#userNumber").setValue(userNumber);
        return this;
    }
    @Step("Set datePicker")
    public PersonalData setDatePicker(String day, String month, String year){
        new DatePicker().openDatePicker().setDatePicker(day, month, year);
        return this;
    }
    @Step("Set subject {value}")
    public PersonalData setSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    @Step("Set hobbies {value}")
    public PersonalData setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    @Step("Upload file {value}")
    public PersonalData uploadFile(String value){
        $("#uploadPicture").uploadFile(new File(String.format("src/test/resources/%s", value)));
        return this;
    }
    @Step("Entering a text {value}")
    public PersonalData setTextarea(String value){
        $("#currentAddress").setValue(value);
        return this;
    }
    @Step("Set state {value}")
    public PersonalData setState(String value){
        $("#state").click();
        new Dropdown().setDropDawn(value);
        return this;
    }
    @Step("Set city {value}")
    public PersonalData setCity(String value){
        $("#city").click();
        new Dropdown().setDropDawn(value);
        return this;
    }
    @Step("Click button")
    public void clickButton(){
        $("#submit").click();
    }

}
