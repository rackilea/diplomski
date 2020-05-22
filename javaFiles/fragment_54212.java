public static void main(String[] args) {
    int totalPrice = 0;
    int creditLimit;

    Scanner input = new Scanner(System.in);



    for (int i = 0; i < 5; i++) {
        System.out.println("Enter total price of item: ");
        totalPrice += input.nextInt();
    }

    System.out.println("Enter credit limit: ");
    creditLimit = input.nextInt();

    System.out.println("The total cost of all items is: " + totalPrice);
    System.out.println("Your credit limit is : " + creditLimit);
    System.out.println("Evaluation result: " + (totalPrice > creditLimit ? "declined" : "approved"));
}