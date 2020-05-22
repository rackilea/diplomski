import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = false)
public abstract class AbstractContainer {

@PersistenceUnit(unitName = "PERSISTENT_UNIT_NAME")
protected EntityManagerFactory factory;

@Autowired
protected ApplicationContext applicationContext;

}