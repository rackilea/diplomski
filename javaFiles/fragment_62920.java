public class UnixTimestampType extends AbstractSingleColumnStandardBasicType<Date> implements IdentifierType<Date>, LiteralType<Date> {
    private static final long serialVersionUID = 1L;
    public static final UnixTimestampType INSTANCE = new UnixTimestampType();

    public UnixTimestampType() {
        super(UnixTimestampTypeDescriptor.INSTANCE, JdbcDateTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String[] getRegistrationKeys() {
        return new String[] { getName(), java.sql.Date.class.getName() };
    }

    @Override
    public String objectToSQLString(Date value, Dialect dialect) throws Exception {
        final java.sql.Date jdbcDate = java.sql.Date.class.isInstance(value) ? (java.sql.Date) value : new java.sql.Date(value.getTime());
        return StringType.INSTANCE.objectToSQLString(jdbcDate.toString(), dialect);
    }

    @Override
    public Date stringToObject(String xml) {
        return fromString(xml);
    }
}