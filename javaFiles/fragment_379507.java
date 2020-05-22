public class OrdersAdapter extends XmlAdapter<OrderType, Map<Long, Order>> {

    @Override
    public Map<Long, Order> unmarshal(OrderType v) throws Exception {
        Map<Long, Order> hashMap = new HashMap<Long, Order>();
        for (Order myEntryType : v.order) {
            hashMap.put(myEntryType.orderId, myEntryType);
        }
        return hashMap;
    }

    @Override
    public OrderType marshal(Map<Long, Order> map) throws Exception {
        OrderType ordType = new OrderType();
        for (Entry<Long, Order> entry : map.entrySet()) {
            Order ordEntryType =
                    new Order();
            ordEntryType.orderId = entry.getKey();
            ordEntryType.price = entry.getValue().price;
            ordEntryType.prodId = entry.getValue().prodId;
            ordType.order.add(ordEntryType);
        }
        return ordType;
    }

}