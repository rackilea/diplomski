public static String carRentalCode(String licensePlate) {
    // precondition:    licensePlate is a valid plate as described in pdf
    // postcondition:   return the car rental code for the licensePlate as described
    int values = 0;
    int ascii = 0;
    int sum = 0;
    int convert = 0;
    char letter;

    char[] ch = licensePlate.toCharArray();

    for (int i = 0; i < ch.length; i++) {
        if (Character.isDigit(ch[i])) {
            values += Character.getNumericValue(ch[i]);
        }
        if (Character.isAlphabetic(ch[i])) {
            ascii += ch[i];
        }
    }
    sum = values + ascii;
    convert = sum % 26 + 65;
    letter = (char) convert;

    String lowercase = licensePlate.replaceAll("\\d+", "").trim().toLowerCase();
    String code = Integer.toString(sum);
    return letter + code + "[" + lowercase + "]";
}