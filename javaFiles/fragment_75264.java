orders
        .stream()
        .collect(Collectors
                .toMap(Order::getCustomer
                        , Order::getOrderLines
                        , (v1, v2) -> { List<OrderLine> temp = new ArrayList<>(v1); 
                                        temp.addAll(v2); 
                                        return temp;});