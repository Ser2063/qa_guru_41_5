import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testdata.TestBase;

import java.util.Locale;

import static testdata.TestData.*;

public class TestBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();


    @Test
    void fillFormTest() {
        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePublicAddress(permanentAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }


    // Негативные тесты
    @Test
    void invalidEmailTest() {
        textBoxPage.openPage()
                .typeUserEmail(userEmailNegNotAnEmail) // "not-an-email"
                .submitForm()
                .userEmailInputShouldHaveErrorClass() // Проверяем наличие CSS-класс ошибки у поля
                .userEmailInputShouldNotBeVisible();
    }

    @Test
    void emptyFormSubmitTest() {
        textBoxPage
                .openPage()
                .submitForm()
                .userEmailInputShouldNotBeVisible()
                .outputNameShouldNotExist();
    }

    @Test
    void incompleteEmailTest() {
        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmailNeg) // sergey@missingdomain Без .ru/.com и т.д.
                .submitForm()
                .userEmailInputShouldHaveErrorClass() // Проверяем наличие CSS-класс ошибки у поля
                .userEmailInputShouldNotBeVisible(); // Проверяем, что блок с результатом не отобразился
    }


    @Test
    void fillFormTest_with_faker() {
        Faker faker = new Faker(new Locale("ru"));
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress= faker.address().fullAddress();


        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePublicAddress(permanentAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }


    @Test
    void fillFormTest_with_utils() {
        String userName = getRandomString(10);
        String userEmail = "Sergey@sergey.ru"; // Правильная почта
        String currentAddress = "Adress 1";
        String permanentAddress= "Adress 2";

        textBoxPage
                .openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePublicAddress(permanentAddress)
                .submitForm()
                .checkField("name", userName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", permanentAddress);
    }



}
