String inValue = in.next();
try {
    a = Integer.parseInt(inValue);
} catch (NumberFormatException ex) {
    // Do something else, like exiting with an error message or setting the value to 0.
}