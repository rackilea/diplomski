public class GenericOrder<T> {

    private List<T> orderItems;

    public GenericOrder() {
        orderItems = new ArrayList<T>();
    }

    public void add(T item) {
        orderItems.add(item);
    }
}