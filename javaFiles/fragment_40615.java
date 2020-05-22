private char[] generateCharSet() {
    String numbers = "0123456789";
    String special = "!£$%^&*()";
    String alphabetsLower = "abcdefghijklmnopqrstuvwxyz";
    String alphabetsUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Add lower alphabets by default
    StringBuilder finalCharset = new StringBuilder(alphabetsLower);

    // Add special chars if option is selected
    if (isSpecChecked == 1) {
        finalCharset.append(special);
    }

    // Add upper case chars if option is selected
    if (isHighCaseChecked == 1) {
        finalCharset.append(alphabetsUpper);
    }

    // Add numbers if option is selected
    if (isNumbChecked == 1) {
        finalCharset.append(numbers);
    }

    // build the final character set
    return finalCharset.toString().toCharArray();
}