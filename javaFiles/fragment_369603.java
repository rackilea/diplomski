import java.util.*;

public class StatisticsTester {

    public static void main(String[] args) {

        Statistics test = new Statistics();
        Scanner input = new Scanner(System.in);
        //Read user  input.
        System.out.print("How many numbers do you want to enter?: ");
        int num = input.nextInt();
        double array[] = new double[num];
        System.out.println("Enter the " + num + "numbers now.");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextDouble();
        }
        System.out.print("Here is the minimum, ");
        System.out.print("maximum, mean, median, ");
        System.out.println("mode, and standard deviation: ");
        System.out.print(test.findMin(array) + ", " + test.findMax(array));
        System.out.print(", " + test.calcMean(array) + ", ");
        System.out.print(test.calcMedian(array) + ", ");
        System.out.print(test.calcMode(array) + ", ");
        System.out.print(test.calcDeviation(array));

    }
}