public Customer lookUpCustomer(String lastName, String firstName) {

    Customer customer;
    Customer foundCustomer = null;

    if (left != null) {

        customer = (Customer) left.getItem();

        if(customer.getLastName().equals(lastName) && customer.getFirstName().equals(firstName)) {
            System.out.println("Found customer: " + customer.toString());
            return customer;
            //foundCustomer = customer;             
        }
        foundCustomer = left.lookUpCustomer(lastName, firstName);
    }
    if (foundCustomer==null && right != null) {

        customer = (Customer) right.getItem();

        if(customer.getLastName().equals(lastName) && 
       customer.getFirstName().equals(firstName)) {
            System.out.println("Found customer: " + customer.toString());
            return customer;
            //foundCustomer = customer;         
        }   
        foundCustomer  = right.lookUpCustomer(lastName, firstName);
    }

    return foundCustomer;
}