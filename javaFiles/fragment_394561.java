Entity create(String name) {
    EntityFactory factory = factories.get(name);
    if (factory == null) {
        throw new NoSuchElementException();
    }
    return factory.create();
}