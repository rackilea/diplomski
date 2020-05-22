import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        System.out.print("Please enter number : ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] t = new int[n];
        int i;
        int j;
        int oddCount = 0;

        System.out.println("These are the generated numbers : ");
        // Loop to do Array
        for (i = 0; i < t.length; i++) {
            t[i] = (int)(Math.random() * 999);
            System.out.println(t[i]);
            if(t[i] % 2 != 0) {
                oddCount++;
            }
        }

        int oddNumbers[] = new int[oddCount];
        // Array which displays odd numbers
        System.out.println("These are the generated Odd numbers : ");
        for (i = 0, j=0; i < t.length; i++) {
            if(t[i] % 2 != 0) {
                oddNumbers[j++] = t[i];
            }
        }
        for (i = 0; i < oddNumbers.length; i++) {
            System.out.println(oddNumbers[i]);
        }
        int evenCount = n - oddCount;
        System.out.println("Even share - " + evenCount);
        double evenPercent = ((double)evenCount/n) * 100.0;
        System.out.println("Even percentage - " + evenPercent);
    }
}