Optional<Customer> dbCustomer = repo.findById(id);
if(dbCustomer.isPresent()) {
    Customer existingCustomer = dbCustomer.get();
    String nameWeWanted = existingCustomer.getName();
    //operate on existingCustomer
} else {
    //there is no Customer in the repo with 'id'
}