class CustomMySQLDialect extends MySQL5InnoDBDialect {
    public CustomMySQLDialect() {
        super();
        registerFunction( "convert_tz", new StandardSQLFunction( "convert_tz", StandardBasicTypes.TIMESTAMP ) );
    }

}