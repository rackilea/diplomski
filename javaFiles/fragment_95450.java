public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number: ");
        int val = in.nextInt();
        int factorial = 1;
        int i = 1;
        while (i <= val) {
            factorial = factorial * i;
            i++;
        }
        System.out.println("The factorial of " + val + " is " + factorial);
    }
}