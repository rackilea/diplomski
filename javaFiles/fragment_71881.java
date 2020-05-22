static void setFirstName() {
    String line;
    boolean valid = false;

    do {
        System.out.print("First Name: ");
        line = sc.nextLine();
        if (line.isEmpty()) {
            System.out.println("Name is empty. Please try again.");
        } else if (isNumeric(line)) {
            System.out.print("Incorrect name format. Please try again.");
        } else {
            valid = true;
        }
    } while (!valid);

    firstName = Character.toUpperCase(line.charAt(0)) + line.substring(1);
} 

static boolean isNumeric(String line) {
    ...
}