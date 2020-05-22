public class Module55 {
    public static void main(String args[]) {

        // declare the array to have 10 items for 10 weeks
        // also declare sum as an int and average as a double to accommodate for
        // decimal points

        int[] weeks = new int[10];
        int sum = 0;
        double average = 0;

        // declare the array values

        weeks[0] = 2;
        weeks[1] = 4;
        weeks[2] = 8;
        weeks[3] = 10;
        weeks[4] = 14;
        weeks[5] = 16;
        weeks[6] = 20;
        weeks[7] = 22;
        weeks[8] = 24;
        weeks[9] = 26;

        // determine sum of the array values
        for (int index = 0; index < weeks.length; index++)
            sum = sum + weeks[index];

        System.out.println("The total miles ran in 10 weeks is " + sum);

        // determine the average of the array values
        if (weeks.length != 0)
            average = (double)sum / weeks.length;
        else
            average = 0;

        System.out.println("The average of the miles ran in 10 weeks is " + average);
    }
}