Set<String> orderIds = ordersSupplier.get().collect(toSet());

file().stream()
      .filter(l -> orderIds.contains(l.id))
      .forEach(
           line -> {
                    //do something;
       });