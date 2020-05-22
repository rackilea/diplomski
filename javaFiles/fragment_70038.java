public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
    // Get an Integer using the numeration system to parse the digits.
    int value = Integer.parseInt(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
    // Convert it to new form.
    return new Number(expectedNumerationSystem, Integer.toString(value, expectedNumerationSystem.getNumerationSystemIntValue()));
}