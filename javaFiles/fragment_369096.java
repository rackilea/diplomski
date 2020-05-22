class Animal {
    private String species;
    private String name;
    private int age;

    public Animal(DBObject dbObject) { ... }
}

class AnimalCollection {
    private final DBCollection collection;        

    public AnimalCollection(Database database) {
        collection = database.getCollection("animals");
    }

    public List<Animal> getAll() {
        List<Animal> animals 
        try (DBCursor cursor = collection.find(query)) {
            while (cursor.hasNext()) {
                animals.add(new Animal(cursor.next());
            }
        }
        return animals;
    }
}