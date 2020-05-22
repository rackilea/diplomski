public class Test {
    private static String[] passwords = {"9999", "coastal", "1"};

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String pin;

        boolean valid = false;
        do {
            System.out.print("Please enter the password: ");
            pin = console.nextLine();
            valid = checkPassword(pin);
        } while (!valid);


    }

    public static boolean checkPassword(String pin) {
        if (Arrays.stream(passwords).anyMatch(pin::equals)) {
            return true;
        } else {
            int count = 0;
            String[] newWord = new String[passwords.length + 1];
            for (int i = 0; i < passwords.length; i++) {
                newWord[i] = passwords[i];
                count++;
            }
            newWord[count] = pin;

            passwords = newWord;
            System.out.print("Password was not in array. It has now been added. Try logging in again.");
            return false;
        }
    }
}