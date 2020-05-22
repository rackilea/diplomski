public class Test {
    public static void main(String[] args) {

        boolean finished;

        do {
            Scanner inputScanner = new Scanner(System.in); //Here you're making a new instance of inputScanner each time you come to this line after the do-while loop ends.
            finished = inputScanner.hasNext("exit");
            boolean validNumber = inputScanner.hasNextDouble();
            if (validNumber) {
                double number = inputScanner.nextDouble();

                System.out.print(number);
            } else if (!finished) {
                System.out.println("Please try again.");
            }
            inputScanner.close();
        } while (!finished);
    }
}