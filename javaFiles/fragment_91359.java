public void allSalesData(Date start,Date end){

    List orders = CustomerOrder.find("select o  from CustomerOrder o where o.orderDate between :startdate and :enddate").bind("startdate",start).bind("enddate",end).fetch();

    Map prodMap = new HashMap();
    Map priceMap = new HashMap();
   Integer quantity = null;
   Long price = null;
   for(CustomerOrder cusOrder: orders) {
      for(OrderItem item: cusOrder.orderItems){
          quantity = prodMap.get(item.product);
          prodMap.put(item.product, quantity + item.quantity);
          price = priceMap.get(item.product);
          priceMap.put(item.product, quantity * item.price cusOrder.tax + cusOrder.shipping + price);
      }
   }

  render(prodMap, priceMap);
}