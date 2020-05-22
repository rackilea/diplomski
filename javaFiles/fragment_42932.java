public static int convertRomanNumber(String romanNumber) {
    romanNumber = romanNumber.toLowerCase();

    if (!isValid(romanNumber)) {
        System.out.println("Invalid character detected");
        System.exit(0);
    }

    int result = 0;
    int currentNumber;
    int nextNumber;

    for (int i = 0; i < romanNumber.length(); i++) {
        currentNumber = convertCharacter(romanNumber, i);
        if (i < romanNumber.length() - 1) {
            nextNumber = convertCharacter(romanNumber, i + 1);
            if (nextNumber > currentNumber) {
                result += currentNumber * -1;
            } else {
                result += currentNumber;
            }
        } else {
            result += currentNumber;
        }
    }

    System.out.println("Your input: " + romanNumber.toUpperCase());

    return result;
}