public static int numberOfCharsInString(String inputString, Character inputChar) {
    int number = 0;
    for (int i = 0; i < inputString.length(); i++) {
        if (inputString.charAt(i) == inputChar)
            number++;
    }
    return number;
}