// This assumes your maps are ConcurrentHashMaps
public Order register(Order value) { // No synchronized here since CHM does it for you
    Map<String, Order> innerMap = getInnerMap(type);
    innerMap.put(value.getId(), value);

    return backing.register(value);
}

private Map<String, Order> getInnerMap(String type) {
    if (!typeView.containsKey(type)) {
        synchronized(typeView)  {
            if (!typeView.containsKey(type)) { // make sure no one else snuck in after you "checked"
                typeView.put(type, new ConcurrentHashMap<>());
            }
        }
    }
    return typeView.get(type);
}

public Order remove(String orderId) { // No synchronized here since CHM does it for you
    Order order = backing.remove(orderId);

    if(order == null) return null;

    String type = order.getType();
    Map<String, Order> innerMap = getInnerMap(type);
    if(innerMap == null) {
        // I suspect this is not the best error handling logic
        throw new IllegalStateException("Somehow the inner map is out of sync!!");
    } else {
        innerMap.remove(order.getId());
        // Could do this if you want, likely not necessary in my use case
        // if (innerMap.isEmpty()) typeView.removeInnerMap(); 
    }

    return order;
}

public Collection<Order> getOrders() {
    return backing.getOrders();
}

public Map<String, Order> getOrdersByType(String type) {
    return Collections.unmodifiableMap(getInnerMap(type));
}