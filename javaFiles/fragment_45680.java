private static class AnimalMap implements Map<Object, Animal> {
    private final Map<Object, Animal> map;

    public AnimalMap() {
        super();
        this.map = new HashMap<Object, Animal>();
    }

    // omitting delegation of all Map<> interface methods to this.map
}

static class ZooSerializer extends SerializerBase<Zoo> {
    public ZooSerializer() {
        super(Zoo.class);
    }

    @Override
    public void serialize(Zoo t, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessing Exception {
        AnimalMap animals = new AnimalMap();
        for (Animal a : t.animals)
            animals.put(a.getName(), a);
        jg.writeObject(animals);
    }
}