package pages;

import java.io.File;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PersonalData {

    public PersonalData setFirstName(String firstName){
        $("#firstName").setValue(firstName);
        return this;
    }

    public PersonalData setLastName(String lastName){
        $("#lastName").setValue(lastName);
        return this;
    }

    public PersonalData setUserEmail(String userEmail){
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public PersonalData setGenterWrapper(String genterWrapper){
        $("#genterWrapper").$(byText(genterWrapper)).click();
        return this;
    }

    public PersonalData setUserNumber(String userNumber){
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public PersonalData setDatePicker(String day, String month, String year){
        new DatePicker().openDatePicker().setDatePicker(day, month, year);
        return this;
    }

    public PersonalData setSubject(String value){
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public PersonalData setHobbies(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public PersonalData uploadFile(String value){
        $("#uploadPicture").uploadFile(new File(String.format("src/test/resources/%s", value)));
        return this;
    }

    public PersonalData setTextarea(String value){
        $("#currentAddress").setValue(value);
        return this;
    }

    public PersonalData setState(String value){
        $("#state").click();
        new Dropdown().setDropDawn(value);
        return this;
    }

    public PersonalData setCity(String value){
        $("#city").click();
        new Dropdown().setDropDawn(value);
        return this;
    }

    public void clickButton(){
        $("#submit").click();
    }




}
