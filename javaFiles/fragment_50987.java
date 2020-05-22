public class UlamSpiral {

    private static int firstNumber, secondNumber;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        getInput();
        if(isPrime(firstNumber) || isPrime(secondNumber)){
            System.out.println("Atleast one of the numbers are a prime number.");
        } else {
           //scenario when none are prime
        }

    }

    public static void getInput() {

        System.out.println("Enter two non-prime numbers");
        firstNumber = scanner.nextInt();
        secondNumber = scanner.nextInt();
    }

    public static boolean isPrime(int num) {
        boolean flag = false;

        for(int i = 2; i <= num / 2; ++i) {

            // Condition for non-prime number.
            if(num % i == 0) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}