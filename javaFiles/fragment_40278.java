public static int[] convertToASCII(String input) {
    int[] ascii = new int[input.length()];
    for (int x = 0; x < ascii.length; x++) {
        ascii[x] = input.codePointAt(x);
    }
    return ascii;
}