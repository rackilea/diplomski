import java.security.SecureRandom;
import java.util.Random;

class Test {

    public static String generatePassword() {
        String chars = "abcdefghijklmnopqrstuvwxyz"
                     + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                     + "0123456789!@%$%&^?|~'\"#+="
                     + "\\*/.,:;[]()-_<>";

        final int PW_LENGTH = 20;
        Random rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < PW_LENGTH; i++)
            pass.append(chars.charAt(rnd.nextInt(chars.length())));
        return pass.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatePassword());
        System.out.println(generatePassword());
        System.out.println(generatePassword());
    }
}