@Stateless(mappedName = "AccountAccessBean")
@LocalBean
public class AccountAccessBean {
    public void resigterAccountEvent() {

        Configuration configuration = new Configuration().configure();
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        SessionFactory sessionFactory = configuration
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Accountaccesslog.class)
                .buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Account accountEntity = (Account) session.get(Account.class, new Integer(1));
        System.out.println(accountEntity.getId());

    }
}