//Postgres Constants Operators
public class PostgresOperators {
    private static final String NS = PostgresOperators.class.getName();
    public static final Operator<Boolean> ILIKE = new OperatorImpl<>(NS, "ILIKE");
}

//Custom JPQLTemplates
public class PostgresTemplates extends HQLTemplates {

    public static final PostgresTemplates DEFAULT = new PostgresTemplates();

    public PostgresTemplates() {
        super();
        add(PostgresOperators.ILIKE, "my_ilike({0},{1})");
    }
}