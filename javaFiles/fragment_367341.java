import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("How many numbers do you want to input?");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int[] values = new int[number];
        for(int i = 0; i < values.length; i++) {
            System.out.println("Give value number " + (i+1) + ":");
            values[i] = in.nextInt();
        }
        List<Integer> prime = new ArrayList<Integer>();
        List<Integer> notPrime = new ArrayList<Integer>();
        for(int i = 0; i < values.length; i++) {
            if(erPrimtall(values[i])) {
                prime.add(values[i]);
            } else {
                notPrime.add(values[i]);
            }
        }
        System.out.println("Prime numbers:");
        for(int n : prime){
            System.out.println(n);
        }
        System.out.println("Other numbers:");
        for(int n : notPrime) {
            System.out.println(n);
        }
        in.close();
    }

    static boolean erPrimtall(int values) {
        boolean isPrime = true;
        for(int i = 2; i <= Math.sqrt(values); i++) {
            if(values % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}