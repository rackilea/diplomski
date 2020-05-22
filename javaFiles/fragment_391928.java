import java.util.Scanner;
  public class assignment2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome\n");
        System.out.println("Sales Month\t\tSales made");
        int sales[] = { 60, 54, 62, 67, 54, 67, 51, 50, 62, 55, 49, 70 };
        int sum = 0;
        for (int counter = 0; counter < sales.length; counter++) {
            sum += sales[counter];
            System.out.println(counter + "\t\t\t\t" + sales[counter]);
        }
        System.out.println("The sum of the sales is " + sum);
    }
}