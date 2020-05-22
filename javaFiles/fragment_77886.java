Integer value = null;
boolean exit = false;

do {
    System.out.print(prompt);
    String input = scanner.nextLine();

    if (escape.equalsIgnoreCase(input)) {
        exit = true;
    } else {
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException exp) {
            System.out.println("!! " + input + " is not a valid int value");
        }
    }
} while (value == null && !exit);