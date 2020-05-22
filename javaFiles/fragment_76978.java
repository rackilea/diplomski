public class MySqlDialectExtended extends MySQLDialect {

public MySqlDialectExtended() {
    super();
    registerFunction("date_add_interval", new SQLFunctionTemplate(Hibernate.DATE, "date_add(?1, INTERVAL ?2 ?3)"));
    registerFunction("date_sub_interval", new SQLFunctionTemplate(Hibernate.DATE, "DATE_SUB(?1, INTERVAL ?2 ?3)"));
    registerFunction("weekofyear", new StandardSQLFunction("weekofyear", Hibernate.INTEGER));
    registerFunction("group_concat", new StandardSQLFunction("group_concat", Hibernate.STRING));
}