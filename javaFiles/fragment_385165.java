public interface FruitProducer<T> {
    T createFruit(String arg);
}

public <T> List<T> returnFruits(String arg, FruitProducer<? extends T> producer) {
    List<T> list = new ArrayList<T>();
    T fruit = producer.createFruit(arg);
    list.add(fruit);
    return list;
}