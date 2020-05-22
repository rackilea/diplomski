final static int noDigits = 5;

public static String myFormat(double d) {
    if (d < 0) {
        throw new IllegalArgumentException("This does not work with a negative number " + d);
    }
    String asString = String.format(Locale.US, "%f", d);
    int targetLength = noDigits;
    int dotIx = asString.indexOf('.');
    if (dotIx >= 0 && dotIx < noDigits) {
        // include dot in result
        targetLength++;
    }
    if (asString.length() < targetLength) { // too short
        return asString + "0000000000000000000000".substring(asString.length(), targetLength);
    } else if (asString.length() > targetLength) { // too long
        return asString.substring(0, targetLength);
    }
    // correct length
    return asString;
}