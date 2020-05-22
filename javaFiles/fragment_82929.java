public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number between 1-15");
    int dig = input.nextInt();
    for (int i = 1; i <= dig; i++) {
        for (int j = 1; j <= dig - i; j++) {
            System.out.printf("%4s", " ");
        }
        for (int k = i; k >= 1; k--) {
            System.out.printf("%4d", k);
        }
        for (int k = 2; k <= i; k++) {
            System.out.printf("%4d", k);
        }
        System.out.println();
    }
}