import java.util.Scanner;

public class Project3x4 {
    public static void main(String [] args){
        Scanner reader = new Scanner(System.in);

        double totalRegularHours;
        double overTimeHours;
        double hourlyWage;
        double totalWeeklyPay;


        System.out.print("Enter the Hourly Wage: ");
        hourlyWage = reader.nextDouble();

        System.out.print("Enter the total amount of regular hours: ");
        totalRegularHours = reader.nextDouble();

        System.out.print("Enter the total amount of over time hours: ");
        overTimeHours = reader.nextDouble();

        double overTimePay;
        overTimePay = overTimeHours * (1.5 * hourlyWage);

        totalWeeklyPay = totalRegularHours * hourlyWage + overTimePay;

        System.out.print("The Total weekly pay is $" );
        System.out.println(totalWeeklyPay);
    }
}