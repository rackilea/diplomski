public class EvenOrOdd {

    public static void main(String[] args) {

        Random random = new Random();
        int evenTotal = 0, oddTotal = 0;
        int iteration = 0;

        System.out.println("Iteration " + " Evens " + " Odds");

        while (iteration < 10) {
            int even = 0, odd = 0;
            for (int i = 0; i < 100; i++) {
                int number2 = random.nextInt(1000) + 1;
                if ((number2 % 2) == 0)
                    even++;
                else if ((number2 % 2) == 1)
                    odd++;

            }
            iteration++;
            System.out.println(iteration + "          " + even + "     " + odd);
            evenTotal += even;
            oddTotal += odd;
        }
        System.out.println("\nEvens: " + evenTotal + "\nOdds:  " + oddTotal);
    }

}