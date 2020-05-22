public enum  Appender implements ConditionAppender {
    AND(" AND "), OR(" OR ");

    final String operation;

    Appender(String operation) {
        this.operation = operation;
    }

    @Override
    public String append() {
        return operation;
    }

    public static void main(String[] args) {
        System.out.println(AND.append());
        System.out.println(OR.append());

    }
}