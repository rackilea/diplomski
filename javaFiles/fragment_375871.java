for(customer_count = 0; customer_count < customerID.length; customer_count++) {
  transaction_Total= 0;
  customer_Total = customerID[customer_count];
  count = customerID[customer_count];
  //System.out.println(count);

  for (int customer_count2 = 0;
       customer_count2 < customerID.length;
       customer_count2++) {                         
    if (customer_Total == customerID[customer_count2]) {
      transaction_Total++;

      //System.out.println(customer_count2);
    }
  }

  System.out.println("Customer: "+ customer_Total + " " +
                     "Transactions: " + transaction_Total); 
}