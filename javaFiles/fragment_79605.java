private void getCustomer() {
    list = new CustomerDAO().getCustomer();
    if(!list.isEmpty()){
        for(Customer c : list){
            Object addItem = table.addItem();
            table.getItem(addItem).getItemProperty("Customer").setValue(c.getName());
        } 
    }
 }