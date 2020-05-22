import java.util.Scanner;

public class ComputeAverage{
    double firstNum;
    double secondNum;
    double thirdNum;

    public void getNumbers(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        firstNum = keyboard.nextDouble();
        System.out.println("Enter your second number: ");
        secondNum = keyboard.nextDouble();
        System.out.println("Enter your third number: ");
        thirdNum = keyboard.nextDouble();
    }
    public double getAverage(){
        return (firstNum + secondNum + thirdNum) / 3.0;

    }

    public static void main(String[] args) {
        ComputeAverage ca = new ComputeAverage();
        ca.getNumbers();
        System.out.println("The average is: " + ca.getAverage());
    }
}