public final class Bill {

    private final int amount;
    private final DateTime dateTime;
    private final List<Integers> orders;

    public Bill(int amount, DateTime dateTime, List<Integer> orders) {
        this.amount = amount; //primitive type: ok
        this.dateTime = dateTime; //joda.DateTime is immutable: ok
        this.orders = new ArrayList<Integer> (orders); //make a copy as the caller could modify the list at its end
    }

    // no method that adds or removes from the list

   public List<Integer> getOrders() {
       return Collections.unmodifiableList(orders); //defensive copy
   }
}