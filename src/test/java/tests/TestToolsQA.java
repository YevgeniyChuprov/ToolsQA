package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.ModalForm;
import pages.PersonalData;

public class TestToolsQA extends BaseTest{

    @Test
    public void test(){
        Configuration.holdBrowserOpen = true;
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
                setGenterWrapper(sex).
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
                setModalForm("Student Name", String.format("%s %s", firstName, lastName)).
                setModalForm("Student Email", emailAddress).
                setModalForm("Gender", sex).
                setModalForm("Mobile", phoneNumber).
                setModalForm("Date of Birth", String.format("%s %s,%s", day, month, year)).
                setModalForm("Subjects", subjects).
                setModalForm("Hobbies", String.format("%s, %s", hobbies1, hobbies2)).
                setModalForm("Picture", imagePath).
                setModalForm("Address", location).
                setModalForm("State and City", String.format("%s %s", state, city));
    }
}
