public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Human> humans = new ArrayList();

        while (true) {
            System.out.println("Please give your first name");
            String firstName = scanner.nextLine();
            System.out.println("Please give your last name");
            String lastName = scanner.nextLine();
            humans.add(new Human(firstName, lastName)); // use your humanService here
            boolean breakOut = false;
            String input;
            do {
                System.out.println("Do you want to enter more names? (Y/N)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                    breakOut = true;
                } else {
                    System.out.println("Invalid input. try again");
                }
            } while (!breakOut);
            if (input.equalsIgnoreCase("Y")) {
                break;
            }
        }
        System.out.println(humans);
    }
}