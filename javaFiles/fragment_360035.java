public static void main(String... args) {
    programLoop:
    {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            final String input = scanner.next();
            switch (input) {
                case "quit":
                    break programLoop; // breaks the while-loop
                default:
                    break; // break the switch
            }
            System.out.println("After the switch");
        }
    }
}