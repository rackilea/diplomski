Scanner scanner = new Scanner(System.in);
int age = -1;
do {
    try {
        System.out.print("Enter ago between 0 and 250 years: ");
        String text = scanner.nextLine(); // Solves dangling new line
        age = Integer.parseInt(text);
        if (age < 0 || age > 250) {
            System.out.println("Invalid age, must be between 0 and 250");
        }
    } catch (NumberFormatException ime) {
        System.out.println("Invalid input - numbers only please");
    }
} while (age < 0 || age > 250);