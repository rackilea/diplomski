while (it.hasNext()) {
 if (sampleOrderMap.containsKey((it.next().getId()))) { // calling it.next()
    if (it.next().getId() != null) { // again calling it.next() ?
       Set<OrderSample> samples = sampleOrderMap.get(it.next().getId()); //again calling 
       for (OrderSample orderSample : samples) {
          Set<Attribute> attributes = attributeOrderMap.get(orderSample.getId());

 ////............ your code