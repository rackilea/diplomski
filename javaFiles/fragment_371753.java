int x = 0;
for(CafeCustomer customer : customers ){
   for(CafeOrders order: itemOrders ){
       if(customer.getOrderNo.equals(order.getOrderId()) ){
           if(x == 0){
               System.out.println(customer.getCustomerName() +"with Id " + 
               customer.getCustomerId()+ "has purchased: "
               +order.getItemName());
               x = 1;
               continue;
           }  
           System.out.printf("%1$40s",order.getItemName());
       }           
   }
   x = 0;
}