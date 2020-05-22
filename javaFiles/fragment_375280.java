abstract class Order {
   public abstract void getSomething();
   public abstract void setSomething();
}

class Burger extends Order {
  // implement getSomething() and setSomething()
}

...
List<Order> orders = new ArrayList<Order>();
...
Burger b = new Burger();
b.setSomething(0);
orders.add(b);
...
for (Order o : orders) {
   o.getSomething();
}