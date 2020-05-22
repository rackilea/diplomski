private Example exampleImpl;

public User(Example exampleImpl) {
    this.exampleImpl = exampleImpl;
}

public void methodUsingExample(Integer val1, Integer val2) {
    exampleImpl.sum(val1, val2);
}