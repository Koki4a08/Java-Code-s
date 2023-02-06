package Java;

import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(int length) {
        String password = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomChar = random.nextInt(122 - 48) + 48;
            if ((randomChar >= 58 && randomChar <= 64) || (randomChar >= 91 && randomChar <= 96)) {
                i--;
            } else {
                password += (char) randomChar;
            }
        }
        return password;
    }

    public static void main(String[] args) {
        int length = 16;
        String password = generatePassword(length);
        System.out.println("Pass: " + password);
    }
}
