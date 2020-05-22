import java.util.Scanner;
    public class InfoDisplay {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String gender;
        char genderChar;

        System.out.print("Enter gender (Male/Female): ");
        gender = sc.next(); //It will not take Enter as an input
        gender = gender.toUpperCase();
        genderChar = gender.charAt(0);


        System.out.println("Your gender is " + genderChar);
    }
}