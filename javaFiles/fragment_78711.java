try {
    if (!isEmpty(value)) {
        lbs = Double.parseDouble(value);
    }
    if (!isEmpty(value2)) {
        ounces = Double.parseDouble(value2) * 0.062500;
    }
} catch (NumberFormatException nfe) {
    //Do some notification
    System.err.println("Invalid input.");
}