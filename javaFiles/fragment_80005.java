public LcdDigit (int newDigitValue, int place) {
    if (newDigitValue >  0) {
        digitValue = newDigitValue;
    }

    if (place == 1) {
        digitValue = digitValue % 10;
    } else if (place == 10) {
        digitValue = (digitValue / 10) % 10;
    } else {
        digitValue = (digitValue / 100) % 10;
    }

}