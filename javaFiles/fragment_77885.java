Integer value = null;
//...
if (escape.equalsIgnoreCase(input)) {
    exit = true;
} else {
    try {
        value = Integer.parseInt(input);
    } catch (NumberFormatException exp) {
        System.out.println("!! " + input + " is not a valid int value");
    }
}