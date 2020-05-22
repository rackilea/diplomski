public class CustomerDao extends BaseDao<Customer> implements ICustomerDao {

    public CustomerDao() {
        super(Customer.class);
    }

    public List<Customer> getCustomers() {
        final List<Customer> list = (List<Customer>) getSessionFactory().
            getCurrentSession()
           .createCriteria(Customer.class).list();
    }
}