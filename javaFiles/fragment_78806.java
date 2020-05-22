private boolean isIbanValid(String iban) {

    int IBAN_MIN_SIZE = 15;
    int IBAN_MAX_SIZE = 34;
    long IBAN_MAX = 999999999;
    long IBAN_MODULUS = 97;

    String trimmed = iban.trim();

    if (trimmed.length() < IBAN_MIN_SIZE || trimmed.length() > IBAN_MAX_SIZE) {
        return false;
    }

    String reformat = trimmed.substring(4) + trimmed.substring(0, 4);
    long total = 0;

    for (int i = 0; i < reformat.length(); i++) {

        int charValue = Character.getNumericValue(reformat.charAt(i));

        if (charValue < 0 || charValue > 35) {
            return false;
        }

        total = (charValue > 9 ? total * 100 : total * 10) + charValue;

        if (total > IBAN_MAX) {
            total = (total % IBAN_MODULUS);
        }
    }

    return (total % IBAN_MODULUS) == 1;
}