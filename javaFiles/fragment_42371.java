List<Delivery> myDeliveryInstances = new ArrayList<Delivery>();

myDeliveryInstances.add(new Delivery("D1", 10));
myDeliveryInstances.add(new Delivery("D2", 25));
myDeliveryInstances.add(new Delivery("D3", 50));

Map<String, Long) deliverer = new HashMap<String, Long>();
for (Delivery delivery : myDeliveryInstances) {
    deliverer.put(delivery.getName(), delivery.getWeight());
}