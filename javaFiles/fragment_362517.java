private static String upperEven(String input) {
    char[] buf = input.toLowerCase().toCharArray();
    boolean upper = false;
    for (int i = 0; i < buf.length; i++) {
        if (Character.isLetter(buf[i])) {
            if (upper)
                buf[i] = Character.toUpperCase(buf[i]);
            upper = ! upper;
        }
    }
    return new String(buf);
}