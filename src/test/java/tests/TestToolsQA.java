package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ModalForm;
import pages.PersonalData;

public class TestToolsQA extends BaseTest{

    @Test
    @DisplayName("Filling out the form")
    public void test(){
//        Configuration.holdBrowserOpen = true;
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                emailAddress = faker.internet().emailAddress(),
                sex = "Male",
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                day = "23",
                month = "February",
                year = "1985",
                subjects = "Maths",
                hobbies1 = "Sports",
                hobbies2 = "Music",
                imagePath = "1.png",
                location = faker.address().streetAddress(),
                state = "NCR",
                city = "Delhi",
                HeaderModalForm = "Thanks for submitting the form";


        new PersonalData().
                setFirstName(firstName).
                setLastName(lastName).
                setUserEmail(emailAddress).
                setGenderWrapper(sex).
                setUserNumber(phoneNumber).
                setDatePicker(day, month, year).
                setSubject(subjects).
                setHobbies(hobbies1).
                setHobbies(hobbies2).
                uploadFile(imagePath).
                setTextarea(location).
                setState(state).
                setCity(city).
                clickButton();


        new ModalForm().
                checkHeaderModalForm(HeaderModalForm).
                checkModalForm("Student Name", String.format("%s %s", firstName, lastName)).
                checkModalForm("Student Email", emailAddress).
                checkModalForm("Gender", sex).
                checkModalForm("Mobile", phoneNumber).
                checkModalForm("Date of Birth", String.format("%s %s,%s", day, month, year)).
                checkModalForm("Subjects", subjects).
                checkModalForm("Hobbies", String.format("%s, %s", hobbies1, hobbies2)).
                checkModalForm("Picture", imagePath).
                checkModalForm("Address", location).
                checkModalForm("State and City", String.format("%s %s", state, city));
    }
}
