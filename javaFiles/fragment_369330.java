import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitTransactionType;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 *
 * @author fernando
 */
public class JPAUtils {  
    private static EntityManagerFactory emf;
    private static final String PERSISTENCE_UNIT = "default"; 
    private static final String DB_NAME = "iguanaauto_db";
    public static String IP_SERVER = "127.000.000.001";

    /** return an entitymanagerfactory */
    public static EntityManagerFactory getEntityManagerFactory(){        
        if(emf == null){
            PersistenceProvider pp = new PersistenceProvider();
            Map<String, String> properties = new HashMap<String, String>();            
            properties.put(PersistenceUnitProperties.TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());                      
            properties.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver");
            properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://" + IP_SERVER + ":3306/" + DB_NAME + "?createDatabaseIfNotExist=true");
            properties.put(PersistenceUnitProperties.JDBC_USER, "root");
            properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
            properties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
            properties.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_DATABASE_GENERATION);
            properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");            
            emf = pp.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
        }
        return emf;
    }

}