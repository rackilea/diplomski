@Stateless(mappedName = "myAppDao")
public class MyAppDaoImpl implements MyAppDaoRemote {

    @PersistenceContext
    private Session session;

    public void someDaoMethod(YourEntity e) {
        // use session directly
        // Transactions are automatically managed by the EJB container
        // because that's one of EJB's raison d'être
    }

}