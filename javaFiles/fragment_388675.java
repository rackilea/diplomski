import org.hibernate.dialect.DB2Dialect;
import java.sql.Types;

public class FixedDB2Dialect extends DB2Dialect {

    public FixedDB2Dialect() {
    super();
    registerColumnType(Types.INTEGER, "decimal($p)");
    registerColumnType(Types.NUMERIC, "decimal($p,$s)");
    registerColumnType(Types.DECIMAL, "decimal($p,$s)");
    }
}