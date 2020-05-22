while (it.hasNext()) {
   Order order = (Order)it.next();  // if Order is your list's type
     if (sampleOrderMap.containsKey((order.getId()))) {
        if (order.getId() != null) {
           Set<OrderSample> samples = sampleOrderMap.get(order.getId());
           for (OrderSample orderSample : samples) {
              Set<Attribute> attributes = attributeOrderMap.get(orderSample.getId());