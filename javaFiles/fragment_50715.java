private Map<Integer, Fruits> fruits = new HashMap<>();

public void addFruit(Fruit fruit) {
    fruits.put(fruit.getfruitUID(), fruit);
}

public Fruit findFruit(Integer fruitUID) {
    return fruits.get(fruitUID);
}