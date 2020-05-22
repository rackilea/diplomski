public class Assignment04 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter your amount");
        long remainder = Math.round(stdin.nextDouble() * 100 );


        long hundreds = remainder / 10000;
        remainder = remainder % 10000;

        long fifties = remainder / 5000;
        remainder = remainder % 5000;

        long twenties = remainder / 2000;
        remainder = remainder % 2000;

        long tens = remainder / 1000;
        remainder = remainder % 1000;

        long fives = remainder / 500;
        remainder = remainder % 500;

        long ones = remainder / 100;
        remainder = remainder % 100;

        long quarters = remainder / 25;
        remainder = remainder % 25;

        long dimes = remainder / 10;
        remainder = remainder % 10;

        long nickels = remainder / 5;
        remainder = remainder % 5;

        long pennies = remainder;




        System.out.println(hundreds + "hundred/s");
        System.out.println(fifties + "fiftie/s");
        System.out.println(twenties + "twentie/s");
        System.out.println(tens + "ten/s");
        System.out.println(fives + "five/s");
        System.out.println(ones + "one/s");
        System.out.println(quarters + "quarter/s");
        System.out.println(dimes + "dime/s");
        System.out.println(nickels + "nickel/s");
        System.out.println(pennies + "cent/s");

    }
}