import java.util.Scanner;

public class PrimeGenerator {
    public static void main(String args[]) {
        Scanner k = new Scanner(System.in);
        System.out.println("Enter an integer");
        int number = k.nextInt();
        PrimeGenerator matt = new PrimeGenerator();
        matt.printPrims(number);
    }

    public void printPrime(int number) {
        for (int i = 2; i <= number; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                 if (i % j == 0) {
                     prime = false;
            }
        }
        if (prime){
            System.out.println(i);
        }
    }
}