String line = myScanner.nextLine();
if (line.matches("^\\p{Alpha}.*$")) {
    System.out.printf("Starts with an alphabetic character: %s%n", line);
    ...
} else {
    ...
}