String accepted = "-+*/()";
for (int i = 0; i < inputExpression.length(); i++) {
    char c = inputExpression.charAt(i);
    if (c >= '0' && c <= '9') continue;
    if (c >= 'a' && c <= 'z') return ErrorType.ALPHABETIC_SYMBOL;
    if (c >= 'A' && c <= 'Z') return ErrorType.ALPHABETIC_SYMBOL;
    if (accepted.indexOf(c) < 0) return ErrorType.UNKNOWN_SYMBOL;
}