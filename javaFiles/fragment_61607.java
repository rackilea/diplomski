List<Customer> customers = (List<Customer>)em.createNativeQuery
        ("SELECT * FROM customers", jpqlexample.entities.Customer.class)
                      .getResultList(); 
Iterator i = customers.iterator();
Customer cust;
while (i.hasNext()) {
    cust = (Customer) i.next();
    //do something
}