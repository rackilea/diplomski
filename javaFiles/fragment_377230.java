import java.util.Scanner;

public class ScoreDice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first input number: ");
        int firstInputInt = scanner.nextInt();
        System.out.print("Enter second input number: ");
        int secondInputInt = scanner.nextInt();
        System.out.println("Returned score from the method scoreWithNumbers: " + scoreWithNumbers(firstInputInt, secondInputInt));
    }

    public static int scoreWithNumbers(int num1, int num2) {
        // If both inputs are 1 or if both inputs are 6, then the returned score is 10
        if ((num1==1 && num2==1) || (num1==6 && num2==6)) {
            return 10;
        // If both inputs are the same (but not 1 or 6 [we checked that above]), then the returned score is 8
        } else if (num1 == num2) {
            return 8;
        // If the inputs are different (i.e if (num1 != num2)), the score is whatever the smaller value is (e.g., if given 3 and 4, it returns 3).  
        } else {
            return Math.min(num1, num2);
        }
    } 
}