class CollectionManager implements AutoCloseable {
    private final Database database;
    private final AnimalCollection animals;

    public CollectionManager(MongoClient client) {
        database = client.getDB("Zoo");
        animals = new AnimalCollection(database);
    }

    @Override
    public void close() {
        database.close();
    }
}