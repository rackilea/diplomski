import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
...
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MyService extends ByBaseService {
...