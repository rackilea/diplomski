import java.util.Random;

/**
 *
 * @author K Neeraj Lal
 */
public class PasswordGeneratorClass {

    private static final int passLength = 40;

    private static int isSpecChecked;
    private static int isHighCaseChecked;
    private static int isNumbChecked;

    public static void main(String[] args) {

        // Iterates from 000 to 111
        for (int i = 0; i < 7; i++) {
            unitTest(i);
        }
    }

    /**
     * Used for testing only
     *
     * @param test input
     */
    private static void unitTest(int test) {
        char[] arr = Integer.toBinaryString(test).toCharArray();

        // turn on/off the options based
        isSpecChecked = Integer.parseInt(Character.toString(arr.length > 0 ? arr[0] : '0'));
        isHighCaseChecked = Integer.parseInt(Character.toString(arr.length > 1 ? arr[1] : '0'));
        isNumbChecked = Integer.parseInt(Character.toString(arr.length > 2 ? arr[2] : '0'));

        char[] charset = generateCharSet();
        generatePassword(charset);
    }

    /**
     * Generates character set
     *
     * @return character set
     */
    private static char[] generateCharSet() {
        String numbers = "0123456789";
        String special = "!£$%^&*()";
        String alphabetsLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetsUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Add lower alphabets by default
        StringBuilder finalCharset = new StringBuilder(alphabetsLower);

        // Add special chars if option is selected
        if (isSpecChecked == 1) {
            finalCharset.append(special);
        }

        // Add upper case chars if option is selected
        if (isHighCaseChecked == 1) {
            finalCharset.append(alphabetsUpper);
        }

        // Add numbers if option is selected
        if (isNumbChecked == 1) {
            finalCharset.append(numbers);
        }

        // build the final character set
        return finalCharset.toString().toCharArray();
    }

    /**
     * Generates the password based on character set
     *
     * @param charset the character set to generate the password from
     */
    private static void generatePassword(char[] charset) {
        final StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < passLength; i++) {
            char c = charset[random.nextInt(charset.length)];
            sb.append(c);
        }

        final String output = sb.toString();
        // passView.setText(output);
        System.out.println(output);
    }
}