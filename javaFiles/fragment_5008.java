public class CustomDialect extends Oracle12cDialect {
    public CustomDialect() {
        super();
        // CustomFunction implements SqlFunction
      //  registerFunction("custom_function", new CustomFunction());
        // or use StandardSQLFunction; useful for coalesce
        registerFunction("todate", new StandardSQLFunction("todate", StandardBasicTypes.DATE));
    }
}