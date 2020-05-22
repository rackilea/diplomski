static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    System.out.print("Enter an integer: ");
    int a = getInt();
    System.out.print("Enter a second integer: ");
    int b = getInt();
    int result = a + b;
    System.out.println(result);
}

public static int getInt() {
    while (true) {
        try {
            String input = sc.nextLine();
            if (!input.contains(" ")) {
                int integer = Integer.parseInt(input);
                return integer;
            } else {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.print("I'm sorry, that's not an integer. Please try again: ");
        }
    }
}