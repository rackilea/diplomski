import org.hibernate.dialect.PostgreSQL9Dialect;    
import java.sql.Types;

public class ArrayPostgreSQLDialect extends PostgreSQL9Dialect {
    public ArrayPostgreSQLDialect() {
        super();
        /*
         *You can change the "numeric[]" type to any other you want.
        */
        this.registerColumnType(Types.ARRAY, "numeric[]");
    }
}