private static String obify (String input) {
    String obifiledInput = "";
    for (int i = 0; i < input.length(); i++) {
        char temp = input.charAt(i);
        if (char == 'A' || char == 'E' || char == 'I' || char == 'O' || char == 'U') {
            obifiledInput += "OB" + temp;
        } else {
            obifiledInput += "" + temp;
        }
    }
    return obifiledInput;
}