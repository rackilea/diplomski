public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //ask user to enter either hex or binary
        System.out.println("Please enter a hex (0x) or binary (0b) number: ");

        //read input as string
        String consoleInput = input.nextLine();

        //if prefix (0x)
        if (consoleInput.startsWith("0x")) {
            consoleInput = consoleInput.replaceAll("0x", "");

            try {
                int hex = Integer.parseInt(consoleInput, 16);
                System.out.println("Converting from base-16 to base-10.\n" + hex);
            } catch (NumberFormatException ex) {
                System.out.println("Error converting string: " + consoleInput);
            }

        } else if (consoleInput.startsWith("0b")) {
            consoleInput = consoleInput.replaceAll("0x", "");

            try {
                int bin = Integer.parseInt(consoleInput, 2);
                System.out.println("Converting from base-2 to base-10.\n" + bin);
            } catch (NumberFormatException ex) {
                System.out.println("Error converting string: " + consoleInput);
            }

        } else {
            System.out.println("I don't know how to covert that number");
        }
    }