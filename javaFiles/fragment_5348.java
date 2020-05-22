import java.util.Scanner;

public class Prog1Methods_FA11 {

String ssn, pw, phoneNumber, line;
Scanner input = new Scanner(System.in);
boolean validPW_Length = true,
        validPW_Symbols = true,
        validPW_enough_Digits = true;
boolean validSSN_Digits = true,
        validSSN_Format = true,
        validSSN_Length = true;
boolean validPhone_Symbols = true,
        validPhone_Format = true,
        validPhone_Length = true;

public Prog1Methods_FA11() {
}

// you may insert a method here to display password status
public void printPASSInfo() {
    System.out.println("\t Password Information");
    System.out.println("The Password:\t" + pw);
    System.out.println("Password Lrngth:\t" + validPW_Length);
    System.out.println("Password has minimum number of digits:\t" + validPW_enough_Digits);
    System.out.println("Password has correct symbols:\t" + validPW_Symbols);
}
}