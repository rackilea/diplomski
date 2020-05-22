public class Test {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("$#0.00");
        double totalPay = 0;
        double result = 1.00;//for showing per day payment
        int totalDays;

        System.out.println("Please enter the number of days you worked: ");
        totalDays = keyboard.nextInt();

        while (totalDays < 1) {
            System.out.println("You have entered an invalid number of days. ");
            System.out.println("Please enter the number of days you worked: ");
            totalDays = keyboard.nextInt();
        }

        for (int counter = 1; counter <= totalDays; counter++) {
            System.out.println("Pay for Day #" + counter + ": " + formatter.format(result));
            totalPay = totalPay + result;//for getting total payment
            result *= 2;//for doubling payment as number of day increase
        }

        System.out.println("TOTAL PAY FOR " + totalDays + " DAYS: " + formatter.format(totalPay));
    }

}