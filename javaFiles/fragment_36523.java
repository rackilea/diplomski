public static String expandedForm(int num) {
    if (num == 0)
        return "0";

    int zeroes = (int) Math.log10(num);
    StringBuilder result = new StringBuilder();

    while (zeroes >= 0) {
        int multiple = (int) Math.pow(10, zeroes);
        int digit = num / multiple;
        result.append(String.valueOf(digit * multiple));

        if (zeroes > 0)
            result.append(" + ");

        num = num % multiple;
        --zeroes;
    }

    return new String(result);
}