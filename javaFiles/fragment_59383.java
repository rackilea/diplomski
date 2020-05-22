for (Customer each_customer : list_of_customers_get_from_retrofit ) {
     for (Order each_order : each_customer.orders_list ) {
       each_order.customer.setTarget(each_customer);
       orderBox.put(each_order);
     }
}