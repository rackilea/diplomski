interface DatabaseInterface{
    void insertNewCustomer(Customer customer);
    void deleteCustomer(long customerDbId);
    List<Customer> findAllCustomers();
    // ...

}