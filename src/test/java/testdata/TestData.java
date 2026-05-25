package testdata;

import static utils.RandomUtils.*;

public class TestData {

    public static String userName = "Sergey";
    public static String userEmail = "Sergey@sergey.ru"; // Правильная почта
    public static String userEmailNeg = "sergey@missingdomain"; // Неправльная почта для негативного теста
    public static String userEmailNegNotAnEmail = "not-an-email"; // Неправльная почта для негативного теста
    public static String userNumberNeg = "123456789"; //короткий номер
    public static String userNumberNega = "abcdefghij"; //буквы вместо цифр
    public static String currentAddress = "Adress 1";
    public static String permanentAddress= "Adress 2";
    public static String uploadPicture = "img.png";


    //Faker

  //  public static String userNameF = "Sergey";
    public static String userEmailF = getRandomEmail(8); // Правильная почта
  //  public static String userEmailNegF = "sergey@missingdomain"; // Неправльная почта для негативного теста
  //  public static String userEmailNegNotAnEmailF = "not-an-email"; // Неправльная почта для негативного теста
  //  public static String userNumberNegF = "123456789"; //короткий номер
  //  public static String userNumberNegaF = "abcdefghij"; //буквы вместо цифр

    public static String currentAddressF = getRandomAddress();
   // public static String permanentAddressF = "Adress 2";

    public static String firstNameF = getRandomFirstName(10);
    public static String lastNameF = getRandomLastName(11);
    public static String userNumberF = getRandomNumber(10);
    public static String genterWrapperF = getRandomGender();
    public static String monthSelectF = getRandomCalendarMonth();
    public static String yearSelectF = getRandomCalendarYear();
    public static String daySelectF = getRandomCalendarDay(monthSelectF, yearSelectF);
    public static String subjectsInputF = getRandomSubject();
    public static String hobbiesWrapperF = getRandomHobbie();
    public static String stateF = getRandomState();
    public static String cityF = (getRandomCity(stateF));

    }
