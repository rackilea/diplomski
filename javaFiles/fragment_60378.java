import java.util.Scanner;

public class Cousins {

public static void main(String[] args) {

    System.out
            .println("Enter a number to calculate the cousins:");
    Scanner teclado = new Scanner(System.in);
    int n = teclado.nextInt();
    boolean cousins;
    for (int m = 3; m < n; m++) {

        boolean rare = true;

        // Needless to check 1 as 1 is cousin to any number and is prime
        for(int i = 2; i <= m; i++) {

            if(mcd(i, m) && !numberIsPrime(i)) {
                rare = false;
            }
        }

        if(rare) {System.out.println(m + " is rare.");}
        else {System.out.println(m + " is not rare.");}
    }
}

public static boolean mcd(int n, int m) {
    boolean cousins = true;
    for (int i = 2; i <= n && i <= m; i++) {
        if (n % i == 0 && m % i == 0) { 
            cousins = false;
        }
    }
    return cousins;
}

public static boolean numberIsPrime(int n) {
    boolean prime = true;

    for(int i = 2; i < n; i++) {
        if(n % i == 0) {prime = false;}
    }

    return prime;
}

}