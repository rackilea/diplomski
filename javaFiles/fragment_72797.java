public static String compress(String input) {
    if (input == null || input.isEmpty()) {
        return input;
    }
    char type = ' ';
    int count = 0;
    StringBuilder output = new StringBuilder();
    int index = 0;
    final int length = input.length();
    while (index < length) {
        char elementType = input.charAt(index);

        // parse number
        int elementCount = 0;
        char c;
        for (index++; index < length && Character.isDigit(c = input.charAt(index)); index++) {
            elementCount = 10 * elementCount + (c - '0');
        }

        if (elementType == type) {
            count += elementCount;
        } else {
            // finish counting last type
            output.append(type).append(count);
            type = elementType;
            count = elementCount;
        }
    }
    output.delete(0, 2); // remove substring added for the initial count/type
    output.append(type).append(count); // append last entry
    return output.toString();
}