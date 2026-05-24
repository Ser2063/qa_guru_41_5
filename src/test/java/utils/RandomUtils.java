package utils;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomFirstName(8));
        System.out.println(getRandomLastName(11 ));
        System.out.println(getRandomEmail(8));
        System.out.println(getRandomNumber(11));
        System.out.println(getRandomInt(111111111, 999999999));
        System.out.println(getRandomPhone());
        System.out.println(getRandomGender());
    }

    public static String getRandomFirstName(int length){

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }


    public static String getRandomLastName(int length){

        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        SecureRandom rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }

    public static String getRandomEmail (int length){

       // return getRandomString(8)+ "@" + getRandomString(8) + ".com";
        return format("%s@%s.com",  getRandomFirstName(8), getRandomFirstName(8));
    }

    public static String getRandomNumber (int length){

        String LETTERS = "0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new SecureRandom();

        for (int i = 0; i < length; i++) {
            result.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }

        return result.toString();
    }



    public static int getRandomInt (int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
        // SecureRandom rnd = new SecureRandom();
        // return rnd.nextInt(max+1);
    }

     // +3 (263) 345 - 77 - 80
    public static String getRandomPhone (){
       String phoneTemplate = "+%s (%s) %s - %s - %s";
       return format(phoneTemplate,  getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }


    public static String getRandomGender_bad_practice (){
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = getRandomInt(0, 2);
        return genders[randomIndex];
    }


    public static String getRandomGender (){
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = getRandomInt(0, 2);
        return getRandomGenderItemFromStringArray(genders);
    }

    public static String getRandomGenderItemFromStringArray( String[] stringArray){
      int arrayLenght = stringArray.length;
      int randomIndex = getRandomInt(0, arrayLenght - 1);
      return stringArray[randomIndex];
    }

}

