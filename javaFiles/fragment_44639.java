public static boolean isValid(String potentialpassword) {
    return potentialpassword.length >= 6 &&
           containsAtLeastOneSpecialCharacter(potentialpassword) &&
           !containsWhitespace(potentialpassword) &&
           startsWithADigit(potentialpassword);
}