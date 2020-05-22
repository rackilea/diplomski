public boolean validateMelliCode(String melliCode) {

    String[] identicalDigits = {"0000000000", "1111111111", "2222222222", "3333333333", "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999"};

    if (melliCode.trim().isEmpty()) {
        Toast.makeText(getApplicationContext(), "Melli Code is empty", Toast.LENGTH_LONG).show();
        return false; // Melli Code is empty
    } else if (melliCode.length() != 10) {
        Toast.makeText(getApplicationContext(), "Melli Code must be exactly 10 digits", Toast.LENGTH_LONG).show();
        return false; // Melli Code is less or more than 10 digits
    } else if (Arrays.asList(identicalDigits).contains(melliCode)) {
        Toast.makeText(getApplicationContext(), "MelliCode is not valid (Fake MelliCode)", Toast.LENGTH_LONG).show();
        return false; // Fake Melli Code
    } else {
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(melliCode.charAt(i)) * (10 - i);
        }

        int lastDigit;
        int divideRemaining = sum % 11;

        if (divideRemaining < 2) {
            lastDigit = divideRemaining;
        } else {
            lastDigit = 11 - (divideRemaining);
        }

        if (Character.getNumericValue(melliCode.charAt(9)) == lastDigit) {
            Toast.makeText(getApplicationContext(), "MelliCode is valid", Toast.LENGTH_LONG).show();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "MelliCode is not valid", Toast.LENGTH_LONG).show();
            return false; // Invalid MelliCode
        }
    }
}