public class SumsInLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the amount of sums you would like to calculate: ");
        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            System.out.println("Please enter the values you would like to sum as pairs of two numbers: ");
            // Read pair and store it inside i-th position of a and b arrays 
            System.out.println("Enter first number: ");
            a[i] = sc.nextInt();
            System.out.println("Enter second number: ");
            b[i] = sc.nextInt();
        }
        // Close scanner
        sc.close();

        // Prints every sum
        for(int i = 0; i < a.length; i++){
            System.out.println(i + "-th sum is: " + (a[i] + b[i]));
        }
    }
}