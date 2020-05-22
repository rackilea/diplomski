import java.util.Scanner;
public class UPC_Check {

public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
        System.out.println("Enter a UPC (enter a blank line to quit): ");
        String upc = in.nextLine(); 
        while (upc.length() <= 12 && upc.length()>0) {
            int odd= Character.getNumericValue(upc.charAt(0))+Character.getNumericValue(upc.charAt(2))+Character.getNumericValue(upc.charAt(4))+Character.getNumericValue(upc.charAt(6))+Character.getNumericValue(upc.charAt(8))+Character.getNumericValue(upc.charAt(10));
            int even= Character.getNumericValue(upc.charAt(1))+Character.getNumericValue(upc.charAt(3))+Character.getNumericValue(upc.charAt(5))+Character.getNumericValue(upc.charAt(7))+Character.getNumericValue(upc.charAt(9));
            int sum= odd*3+even;
            int cd= Character.getNumericValue(upc.charAt(11));

            if (sum%10 !=0) {
                int sub= 10-(sum%10);
                if (sub==cd) {
                    System.out.println("Check digit should be: " +sub);
                    System.out.println("Check digit is: "+ cd);
                    System.out.println("valid");
                    System.out.println("Enter a UPC (enter a blank line to quit): ");
                    upc= in.nextLine();
                }
                else {
                    System.out.println("Check digit should be: " +sub);
                    System.out.println("Check digit is: "+ cd);
                    System.out.println("not valid");
                    System.out.println("Enter a UPC (enter a blank line to quit): ");
                    upc= in.nextLine();
                }
            }
        }

        if (upc.length()==0) {
            System.out.println("Goodbye");
        }


}