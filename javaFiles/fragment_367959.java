public class ExtendedPostgresDialect extends org.hibernate.dialect.PostgreSQL82Dialect {
    public ExtendedPostgresDialect() {
        super();
        registerFunction("my_ilike", new PostgreSQLIlikeFunction());
    }
}