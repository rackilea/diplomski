List<Integer> list = new ArrayList<>();

for (Fruits fruit : Fruits.values()) {
    for (int i = 0; i < fruit.getAmount(); i++) {
        list.add(fruit.getFruitId());
    }
}