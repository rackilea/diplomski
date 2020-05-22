try {
    assignmentValue = Integer.parseInt(keyboard.nextLine());
}
catch (NumberFormatException exc) {
    throw new InputMismatchException(exc.getMessage());
}