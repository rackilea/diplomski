import java.util.Scanner;

public class test {
    public static void main(String args[]){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Please enter the coefficients of a polynomial’s terms:");
        String coefficents = user_input.nextLine();
        String[] three = coefficents.split(" ");
        for (String i: three) {
            System.out.print(i);
        }
    }
}