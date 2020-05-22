//if prefix (0x)
        if (consoleInput.startsWith("0x")) {
            consoleInput = consoleInput.replaceAll("0x", "");
            // ...
        } else if (consoleInput.startsWith("0b")) {
            consoleInput = consoleInput.replaceAll("0x", "");
            int bin = Integer.parseInt(consoleInput, 2);
            // ...
        } else {
            System.out.println("I don't know how to covert that number");
        }