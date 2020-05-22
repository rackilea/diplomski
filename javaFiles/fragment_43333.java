private int[] numberAsDigits(int number) {
    String numberAsString = String.valueOf(number);
    int[] numberAsDigits = new int[numberAsString.length()];
    char[] chars = numberAsString.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        numberAsDigits[i] = Integer.parseInt(String.valueOf(chars[i]));
    }
    return numberAsDigits;
}