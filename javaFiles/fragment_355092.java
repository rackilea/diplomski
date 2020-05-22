while (in.hasNext()) {
    String token = in.next();
    try {
        // try to convert string to double
        double d = Double.parseDouble(token);
        doubles += 1;
        sumOfDoubles += d;
    } catch (NumberFormatException e) {
        // conversion failed - it's not a double
        nonDoubles += 1;
    }
}