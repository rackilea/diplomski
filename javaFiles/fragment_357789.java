int testValue;
try {
    testValue = Integer.parseInt(inputLine, 10);
} catch (NumberFormatException ex) {
    // The user typed in something that isn't a number.  Alert the user somehow, and make
    // him or her try again
}