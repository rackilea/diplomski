public static void main(String[] args) {
    String input = "(123456";

    if(input.charAt(0) == '(') {
        System.out.println(getDigit(input));
    }
}

private static int getDigit(String s) {
    int result = 0;
    int increase = 10;

    for(int i = 1; i < s.length(); i++) {
        int digit = Character.getNumericValue(s.charAt(i));
        result*=increase;
        result += digit;
    }

    return result;
}