private void getCustomer() {
    list = new CustomerDAO().getCustomer();
    if(!list.isEmpty()){
        for(Customer c : list){
             table.addItem(new Object[] { c.getName() }, null);
        } 
    }
 }