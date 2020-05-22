public class CustomerDaoServiceImpl implements CustomerDaoService{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public boolean saveCustomer(Customer customer) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return false;
    }
}