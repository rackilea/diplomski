public interface CustomerRepository {

    Customer getById(Integer id, CustomerFetchingStrategy fetchingStrategy);
    List<Customer> getAll(CustomerFetchingStrategy fetchingStrategy);

    public static enum CustomerFetchingStrategy {
        PROXY,
        CUSTOMER,
        CUSTOMER_WITH_ORDERS;         
    }

}