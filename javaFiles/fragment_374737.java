import java.sql.Types;
import org.hibernate.dialect.H2Dialect;

public class H2DialectCustom extends H2Dialect {

    public H2DialectCustom() {
        super();
        registerColumnType(Types.BINARY, "varbinary");
    }

}