package EXERCISE;

public class Main {

    public static void main(String[] args) {

        System.out.println(toMilesPerHour(0));

    }

    public static double toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            return -1;
        }
        else if (kilometersPerHour > 0) {
            return kilometersPerHour * 1.609d;
        }
        else if (kilometersPerHour == 0) {
            return 0;
        }
        return kilometersPerHour * 1.609;
        //if I don't write return here it gives me no return statement error,
        //if I write it, it gives me no output with value > or < 0 but no error.
    }
}