import java.util.Scanner;

    public class ParkingCharges {

        static Scanner input = new Scanner(System.in);
        static double minimum_fee = 2.0;
        static double maximum_fee = 10.0;
        static double extra_per_HourCharge = 0.50;
        int daily_hours;

        public static void main(String[] args) {
            Display();
            //as Alexandro Sifuentes Díaz suggested
            double hoursParked = hoursEntered();

            //change if (that runs once) to  a loop
            while ((hoursParked <= 0.0) || (hoursParked >24)) {
                System.out.println("Invalid hours entered. Valid hours are 1 through 24");
                Display();
                hoursParked = hoursEntered();
            }

            if (hoursParked <= 3.0) {
                System.out.println("Minimum number of hours parked, fee is: " + minimum_fee);
            } else {
                //obtain and output the parking charge  
                System.out.println("Parking fee is " +extraCharge(hoursParked));

            }
        }

        static void Display() {
            System.out.println(" Enter the number of hours parked: \n");
        }

        public static double hoursEntered() {
            double numberOfHours = input.nextDouble();
            System.out.println(numberOfHours);
            return numberOfHours;
        }

        //use hoursParked obtained earlier
        public static double extraCharge(double hoursParked) {
            double extraChargeAmount = 0.0;
            extraChargeAmount = minimum_fee + ((hoursParked - 3)*extra_per_HourCharge);
            if (extraChargeAmount >= 10.0) {
                extraChargeAmount = 10;
                //removed un needed return and else else
            }
             return extraChargeAmount;

        }
    }