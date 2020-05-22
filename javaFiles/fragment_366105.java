public boolean checkNum(long num) {

    String number = String.valueOf(num);
    char[] numDigits = number.toCharArray();

    long sum = 0;
    // a simple way to obtain the number of digits
    int power = numDigits.length;

    for (int i = 0; i < numDigits.length; i++) {
        // this is how we transform a character into a digit
        int digit = Character.digit(numDigits[i], 10);
        // we need to rise digit to the value of power
        sum = sum + (long) Math.pow(digit, power);
    }

    if (sum == num) {
        return true;
    } else {
        return false;
    }

}