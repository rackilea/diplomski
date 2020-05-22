public static String answerKey(Fraction pecahan1, Fraction pecahan2, char operator) {
        switch (operator) {
        case '+':
            return pecahan1.addFraction(pecahan2);
        case '-':
            return pecahan1.subtractFraction(pecahan2);
        case '*':
            return pecahan1.multiplyByFraction(pecahan2);
        case '/':
            return pecahan1.divideByFraction(pecahan2);
        default:
            return null;
        }