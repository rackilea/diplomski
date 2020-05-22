public class MyPostgreSQL9Dialect extends PostgreSQL94Dialect {

    public MyPostgreSQL9Dialect() {
        super();
        registerFunction("calculate", new StandardSQLFunction("calculate"));
    }
}