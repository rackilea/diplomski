enum Operator {

    PLUS("+"),
    MINUS("-"),
    ASTERISK("*"),
    SLASH("/");

    private static final Map<String, Operator> tokenToOperatorIndex = createTokenToOperatorIndexInJava8();

    private final String token;

    Operator(final String token) {
        this.token = token;
    }

    static Operator resolveOperator(final String token)
            throws NoSuchElementException {
        final Operator operator = tokenToOperatorIndex.get(token);
        if ( operator == null ) {
            throw new NoSuchElementException("Cannot resolve operator by " + token);
        }
        return operator;
    }

    private static Map<String, Operator> createTokenToOperatorIndex() {
        final Map<String, Operator> index = new HashMap<>();
        for ( final Operator operator : values() ) {
            index.put(operator.token, operator);
        }
        return unmodifiableMap(index);
    }

    private static Map<String, Operator> createTokenToOperatorIndexInJava8() {
        final Map<String, Operator> index = Stream.of(values())
                .collect(toMap(operator -> operator.token, identity()));
        return unmodifiableMap(index);
    }

}