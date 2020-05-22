import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class ExtendedSqlServerDialect extends SQLServerDialect {

    public ExtendedSqlServerDialect() {
        registerFunction("weekdiff", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "datediff(week, ?2, ?1)"));
    }
}