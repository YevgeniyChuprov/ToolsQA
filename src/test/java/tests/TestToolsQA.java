package tests;

import org.junit.jupiter.api.Test;
import pages.ModalForm;
import pages.PersonalData;

public class TestToolsQA extends BaseTest{

    @Test
    public void test(){
        new PersonalData().
                setFirstName("Evgeny").
                setLastName("Сhuprov").
                setUserEmail("myemail@mail.my").
                setGenterWrapper("Male").
                setUserNumber("1234567890").
                setDatePicker("23", "February", "1985").
                setSubject("Math").
                setHobbies("Sports").
                setHobbies("Music").
                uploadFile("src/test/resources/1.png").
                setTextarea("Some kind of address").
                setState("NCR").
                setCity("Delhi").
                clickButton();


        new ModalForm().
                checkHeaderModalForm("Thanks for submitting the form").
                setModalForm("Student Name", "Evgeny Сhuprov").
                setModalForm("Student Email", "myemail@mail.my").
                setModalForm("Gender", "Male").
                setModalForm("Mobile", "1234567890").
                setModalForm("Date of Birth", "23 February,1985").
                setModalForm("Subjects", "Maths").
                setModalForm("Hobbies", "Sports, Music").
                setModalForm("Picture", "1.png").
                setModalForm("Address", "Some kind of address").
                setModalForm("State and City", "NCR Delhi");
    }
}
