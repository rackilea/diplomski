import static br.com.app.CustomerRepository.CustomerFetchingStrategy;

public class CustomerRepositoryImpl implements CustomerRepository {

    // Usually Spring IoC or Seam @In-jection or something else
    private SessionFactory sessionFactory;

    public Customer getById(Integer id, CustomerFetchingStrategy fetchingStrategy) {
        switch(fetchingStrategy) {
            case PROXY:
                return (Customer) sessionFactory.getCurrentSession().load(Customer.class, id);
            case CUSTOMER:
                return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
            case CUSTOMER_WITH_ORDERS:
                return (Customer) sessionFactory.getCurrentSession().createQuery("from Customer c left join fetch c.orderList where c.id = :id")
                                  .setParameter("id", id)
                                  .list().get(0);
        }
    }

    public List<Customer> getAll(CustomerFetchingStrategy fetchingStrategy) {
        // Same strategy as shown above
    }

}