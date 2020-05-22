import java.util.Scanner;

public class Calculator {    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in) ;
        System.out.println("Enter your two numbers and the operation with spaces between e.g 8 9 -");

        String calculation=scan.nextLine();

        String [] parts = calculation.split(" ");

        int part1 = Integer.parseInt(parts[0]);
        int part2 = Integer.parseInt(parts[1]);

        int answer;
        String operation = parts[2];
        switch (operation) {
            case "+":
                answer = part1 + part2;
                break;
            case "-":
                answer = part1 - part2;
                break;
            case "*":
                answer = part1 * part2;
                break;
            case "/":
                answer = part1 / part2;
                break;
            default:
                throw new IllegalStateException("Incorrect operation: " + operation);
        }

        String ans = String.valueOf(answer);
        System.out.println(ans);
    }    
}