package com.sardeni;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormPageObjects extends TestBase {
    Faker faker = new Faker();

    @Test
    @DisplayName("Проверка заполнения формы регистрации")
    void studentRegistrationFormTest() {

        String name = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phoneNumber = faker.phoneNumber().subscriberNumber(10),
                currentAddress = faker.address().fullAddress(),
                gender = "Male",
                dateOfBirth = "5 May,1987",
                subject = "Computer Science",
                hobbies = "Sports, Reading",
                pictureFIleName = "brad_pitt.png",
                pictureSource = "images/brad_pitt.png",
                stateAndCity = "NCR Noida",
                hobbieSport = "Sports",
                hobbieRead = "Reading",
                state = "NCR",
                city = "Noida";

        step("open page", () -> {
            registrationPage.openPage();
        });

        step("fill the form", () -> {
            registrationPage.setFirstName(name)
                    .setLastName(lastName)
                    .setUserEmail(email)
                    .setGender(gender)
                    .setUserPhoneNumber(phoneNumber)
                    .setBirthDate("05", "May", "1987")
                    .setSubject(subject)
                    .setHobbie(hobbieSport)
                    .setHobbie(hobbieRead)
                    .uploadPhoto(pictureSource)
                    .setAddress(currentAddress)
                    .selectState(state)
                    .selectCity(city)
                    .clickSubmitButton();
        });

        step("verification added data in the table", () -> {
            registrationPage.verifyResultsModalAppears();
            registrationPage
                    .verifyResult("Student Name", name + " " + lastName)
                    .verifyResult("Student Email", email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phoneNumber)
                    .verifyResult("Date of Birth", dateOfBirth)
                    .verifyResult("Address", currentAddress)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", pictureFIleName)
                    .verifyResult("State and City", stateAndCity);
        } );
    }
}
