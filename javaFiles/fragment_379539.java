public class BankDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public long save(Bank bank) {
        Session s = sessionFactory.getCurrentSession();
        s.save(bank);
        return bank.getId();
    }
    ...
}