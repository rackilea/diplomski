enum CallableEnum {
    CALLABLE_ONE("insert_new_cat", 3),
    CALLABLE_TWO("update_cat", 2),
    ;

    private String sql;
    private int parameterCount;

    private CallableEnum(String sql, int params) {
        this.sql = sql;
        this.parameterCount = params;
    }

    public CallableStatement prepare(Connection connection) throws SQLException {
        final StringBuilder builder = new StringBuilder("{CALL ");
        builder.append(this.sql);
        builder.append("(");

        int count = this.parameterCount;
        for (int i = 0; i < count; i++) {
            builder.append("?");
            if (i != count - 1) {
                builder.append(", ");
            }
        }

        return connection.prepareCall(builder.append(")}").toString());
    }
}