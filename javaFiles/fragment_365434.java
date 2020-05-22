import java.util.Scanner;

class howstrong {
    public static void main(final String ar[]) {
        String password;
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER PASSWORD");
        password = in.next();

        boolean hasLetter = false;
        boolean hasDigit = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isLetter(x)) {

                    hasLetter = true;
                }

                else if (Character.isDigit(x)) {

                    hasDigit = true;
                }

                // no need to check further, break the loop
                if(hasLetter && hasDigit){

                    break;
                }

            }
            if (hasLetter && hasDigit) {
                System.out.println("STRONG");
            } else {
                System.out.println("NOT STRONG");
            }
        } else {
            System.out.println("HAVE AT LEAST 8 CHARACTERS");
        }
    }
}