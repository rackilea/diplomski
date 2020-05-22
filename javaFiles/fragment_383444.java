public class ... implements Serializable {
    ...
    private transient Map<String, Car> cars = new HashMap<>();
    ...
    private void readObject(ObjectInputStream stream)
              throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        // Important! recreate transient field cars as empty HashMap
        this.cars = new HashMap<>();
    }
    ...
}