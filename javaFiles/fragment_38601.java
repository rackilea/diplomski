private static final int rankOperator(char op) {
    switch (op) {
        case '-' : return 0;
        case '+' : return 0;
        case '/' : return 2;
        case '*' : return 2;
        case '%' : return 4;
    }
    throw new IllegalStateException("Unknown operator " + op);
}


public boolean hasHigherPrecedence(char top, char current) {
    return rankOperator(top) > rankOperator(current);
}