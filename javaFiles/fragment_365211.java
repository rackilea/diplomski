public class DateTimeArgumentFactory implements ArgumentFactory<DateTime> {
    @Override
    public boolean accepts(Class<?> expectedType, Object value, StatementContext ctx) {
        return value != null && DateTime.class.isAssignableFrom(value.getClass());
    }

    @Override
    public Argument build(Class<?> expectedType, final DateTime value, StatementContext ctx) {
        return new Argument() {
            @Override
            public void apply(int position, PreparedStatement statement, StatementContext ctx) throws SQLException {
                statement.setTimestamp(position, new java.sql.Timestamp(value.getMillis()));
            }
        };
    }
}