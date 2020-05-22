int evaluateE(String s) {
    //Base case
    if (!s.contains("+") && !s.contains("-") && !s.contains("*") && !s.contains("/")) {
        return Integer.parseInt(s);
    }

    int i;

    for (i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            break;
        } else if (s.charAt(i) == '*' || s.charAt(i) == '/') {
            break;
        }
    }

    String r1 = s.substring(0, i);
    String r2 = s.substring(i + 1, s.length());

    int result = 0;

    switch (s.charAt(i)) {
        case '+':
            result = evaluateE(r1) + evaluateE(r2);
            break;
        case '-':
            result = evaluateE(r1) - evaluateE(r2);
            break;
        case '*':
            result = evaluateE(r1) * evaluateE(r2);
            break;
        case '/':
            int right = evaluateE(r2);
            if (right == 0) //if denominator is zero
            {
                System.out.println("Invalid divisor");
                System.exit(1);
            } else {
                result = evaluateE(r1) / right;
            }
            break;
    }
    return result;

}