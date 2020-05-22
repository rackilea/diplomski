enum CallableEnum {
    CALLABLE_ONE("insert_new_cat", 3, new Executable<Long>() {
        @Override
        public Long apply(CallableStatement statement, Object... arguments) throws SQLException {
            statement.setString(1, String.valueOf(arguments[0]));
            statement.setInt(2, Integer.parseInt(String.valueOf(arguments[1])));
            statement.registerOutParameter(3, Types.NUMERIC);
            statement.execute();
            return statement.getLong(3);
        }
    }),
    ;

    private String sql;
    private Executable<?> executable;
    private int parameterCount;

    private CallableEnum(String sql, int params, Executable<?> todo) {
        this.sql = sql;
        this.parameterCount = params;
        this.executable = todo;
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

    public <T> T execute(Connection conn, Object... arguments) throws SQLException {
        CallableStatement st = this.prepare(conn);
        return (T) this.executable.apply(st, arguments);
    }

    private interface Executable<T> {
        T apply(CallableStatement st, Object... arguments) throws SQLException;
    }
}