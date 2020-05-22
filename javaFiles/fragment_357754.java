@ApplicationScoped
public class Observer {

    @Inject
    private Repository repository;

    public void onApplicationStarted(@ObservesAsync ApplicationStarted applicationStarted) throws Exception {
        UserTransaction userTransaction = (UserTransaction) new InitialContext().lookup("java:jboss/UserTransaction");
        userTransaction.begin();
        try {
            repository.getSomethingFromDatabase();
            // or repository.persistSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
        userTransaction.commit();
    }
}