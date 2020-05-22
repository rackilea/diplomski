import java.util.Scanner;
public class Input_Program {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number :");
        int a = in.nextInt();
        System.out.println("Enter the second number :");
        int b = in.nextInt();


        System.out.println("Value of first number:" + a);
        System.out.println("Value of second number:" + b);

        System.out.println("Do you want Add two numbers");
        System.out.println("To Continue: Type Yes");

        String s = in.next();

        if(s.toLowerCase().contains("y")){   
            int sum=a+b;
            System.out.println("Summation :"+sum);  
        }

    }  
}