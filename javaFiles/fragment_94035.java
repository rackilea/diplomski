static String inputCheck() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.toUpperCase().equals("END")) {
            end();
        }
        return input;
    }