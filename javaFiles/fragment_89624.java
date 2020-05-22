interface CustomerRepository implements Repository<Customer, Long> {

  Page<Customer> findByLastname(String lastname, Pageable pageable);

  List<Customer> findByFirstname(String firstname, Pageable pageable);
}