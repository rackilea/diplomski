if (Pattern.compile("[A-Za-z]").matcher(inputExpression).find()) {
    return ErrorType.ALPHABETIC_SYMBOL;
} else if (Pattern.compile("[^-+*/()0-9]").matcher(inputExpression).find()) {
    // [^...] negates a character class
    return ErrorType.UNKNOWN_SYMBOL;
}