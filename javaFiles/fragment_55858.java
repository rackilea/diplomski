public static String overlay2(String value, String with, int at) {
    String result = null;
    if (at >= value.length()) {
        throw new IllegalArgumentException("Insert point is beyond length of original String");
    } else {
        StringBuilder sb = new StringBuilder(value);
        // Assuming a straight replacement with out needing to 
        // check for white spaces...otherwise you can use
        // the same type of loop from the first example
        sb.replace(at, with.length(), with);
        result = sb.toString();
    }
    return result;
}

overlay2("Hello World", 
         "Hi", 
         5));