public class HSQL_1_8_X_Dialect extends HSQLDialect {

    public HSQL_1_8_X_Dialect() {
        super();

        registerColumnType(Types.BLOB, "varbinary");
        registerColumnType(Types.CLOB, "varchar");
    }
}

<property name="hibernate.dialect" value="com.savdev.datasource.dialect.HSQL_1_8_X_Dialect"/>