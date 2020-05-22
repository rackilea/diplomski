public static String EnglishName(int num1, int num2) {

    String numberAndDecimal = "";

    if (num2 == 3) {
        numberAndDecimal = num1 + "." + num2 + " not rounded up its still "
                + translate(num1);
    }
    if (num2 == 4) {
        numberAndDecimal = num1 + "." + num2 + " not rounded up its still "
                + translate(num1);
    }
    if (num2 == 5) {
        numberAndDecimal = num1 + "." + num2 + " was rounded up, it's now "
                + translate(num1 + 1);
    }
    if (num2 == 6) {
        numberAndDecimal = num1 + "." + num2 + " was rounded up, it's now "
                + translate(num1 + 1);
    }

    return numberAndDecimal;
}

public static String translate(int num1) {

    String numberInWords = "";

    if (num1 == 1) {
        numberInWords = "one";
    }
    if (num1 == 2) {
        numberInWords = "two";
    }
    if (num1 == 3) {
        numberInWords = "three";
    }
    if (num1 == 4) {
        numberInWords = "four";
    }
    if (num1 == 5) {
        numberInWords = "five";
    }

    return numberInWords;
}