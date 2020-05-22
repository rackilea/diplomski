for(int i; i < size; i++) {
   customer = customers.getCustomerAt(i);
   data[i][0] = Integer.toString(customer.getCustomerID());
   data[i][1] = customer.getfName();
   data[i][2] = customer.getlName();
}