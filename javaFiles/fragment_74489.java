public class Garage<T extends Convertible> {
    private int capacity;
    private List<T> cars = new LinkedList<T>();

    public Garage(int capacity) {
        this.capacity = capacity;
    }
}