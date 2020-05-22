for(Integer id:customerIds){
            CustomerDTO customer = getCustomer(id);
            System.out.println("correct output: "+customer.getCustomerId());//getting correct output here
            customerList.add(customer);//Trying to add copied object in list
        }

for(customer ids 1 to 4){
       customer will get reference CustomerDTO@60bc92 and will be updated based on customer ids
       so it is printing correct values 
       but it is adding same reference CustomerDTO@60bc92 to the list
}

 for(CustomerDTO customer: customerList){
            System.out.println("wrong output: "+customer.getCustomerId());//getting wrong output here
        }

for(all customer object in list which is same object reference and having latest value means 4){
      it is printing wrong value as 4
}