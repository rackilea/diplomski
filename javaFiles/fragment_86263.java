import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class ExtendedHsqlDialect extends SQLServerDialect {

    public ExtendedHsqlDialect() {
        registerFunction("weekdiff", new SQLFunctionTemplate(StandardBasicTypes.INTEGER, "truncate(datediff('day', ?2, ?1) / 7)"));
    }
}