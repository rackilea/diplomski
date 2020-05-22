package test;

/**
 *
 * @author Tyler Weaver
 */
public class Test {

    public static void main(String[] args) {
        // if (args.length == 0) // Generate password
        //{

        //System.out.println("Your new password is: " + generateValidPassword());
        //} 
        if (args.length == 1) // Test password
        {
            System.out.print("The password you entered, " + args[0]);

            if (isValidPassword(args[0])) {
                System.out.println(" is a valid password");
            } else {
                System.out.println(" is NOT a valid password");
            }
        } else // To many command line arguments, educate user
        {

            System.out.println();
            System.out.println("This program takes either zero or one parameter.");
            System.out.println("When run with zero parameters it will generate a password.");
            System.out.print("When run with one parameter it will test whether");
            System.out.println(" the parameter is a valid password.");
            System.out.println();
            System.out.println("A valid password has the following four properties:");
            System.out.println("1. A valid password contains between 8 and 14 characters, inclusive.");
            System.out.println("2. A valid password contains two or more uppercase letters [A-Z].");
            System.out.println("3. A valid password contains two or more lowercase letters [a-z]");
            System.out.println("4. A valid password contains two or more numbers [0-9]");
            System.out.println();
            System.out.println();
        }
    }

    static private boolean isValidPassword(String testPassword) {
        int uppercasecount = 0;
        int lowercasecount = 0;
        int numbercount = 0;

        for (int count = 0; count < testPassword.length(); count++) {
            char cur = testPassword.charAt(count);

            if (CharacterIsNumber(cur)) {
                numbercount++;
            } else if (CharacterIsUppercase(cur)) {
                uppercasecount++;
            } else if (CharacterIsLowercase(cur)) {
                lowercasecount++;
            }
        }

        return (uppercasecount >= 2 && 
                lowercasecount >= 2 &&
                numbercount >= 2);
    }

    static public boolean CharacterIsNumber(char testChar) {
        return Character.isDigit(testChar);
    }

    static public boolean CharacterIsUppercase(char testChar) {
        return Character.isUpperCase(testChar);
    }

    static public boolean CharacterIsLowercase(char testChar) {
        return Character.isLowerCase(testChar);
    }
}