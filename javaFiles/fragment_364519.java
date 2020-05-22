public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter an integer: ");
    int a = input.nextInt();
    System.out.println("What power do you want " + a + " to be raised to? ");
    int b = input.nextInt();

    if (b > 0) {
        System.out.print(a);
        for (int i = 1; i < b; i++)
            System.out.print(" x " + a);
    } else {
        System.out.println(a + "^" + b + " cannot be expanded!");
    }
}