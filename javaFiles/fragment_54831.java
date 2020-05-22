public <E extends Animal & IQuadruped> void testFunction(E param) {
    List<E> list = new ArrayList<E>();
    list.add(param);
}

public void addDog() {
    testFunction(new Dog())
}