import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input;
        do {
            input = displayMenu();
            switch (input) {
                case "1":
                    customers.main(args);
                    break;
                case "2":
                    cars.main(args);
                    break;
                case "3":
                    Staff.main(args);
                    break;
            }
        } while (!"exit".equals(input));
    }

    private static String displayMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Customers");
        System.out.println("2. Cars");
        System.out.println("3. Staff");

        System.out.println("Which would you like to add/edit: ");
        return input.nextLine();
    }
}

class customers {
    public static void main(String[] args) {
        System.out.println("hello from 'customers'!");
    }
}

class cars {
    public static void main(String[] args) {
        System.out.println("hello from 'cars'");
    }
}

class Staff {
    public static void main(String[] args) {
        System.out.println("hello from 'Staff'");
    }
}