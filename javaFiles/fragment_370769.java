if (validSin) {
    String sinTwo = sinNumber.replace("-", "");
    int sum = 0;
    for (int i = 0; i < sinTwo.length(); i++) {
        int digit = Character.getNumericValue(sinTwo.charAt(i));
        if (i % 2 != 0) {
            digit = digit * 2;
        }
        digit = digit / 10 + digit % 10;
        sum += digit;
    }
    validSin = sum % 10 == 0;
}