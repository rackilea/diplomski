class Chunk implements Supplier<Element> {
    private final Generator generator;
    private final int chunkSize;
    private List<Element> list = Collections.emptyList();
    private int index = 0;

    public Chunk(Generator generator, int chunkSize) {
        assert chunkSize > 0;
        this.generator = generator;
        this.chunkSize = chunkSize;
    }

    @Override
    public Element get() {
        if (list.isEmpty()) {
            list = generator.retrieve(index, index + chunkSize);
            index += chunkSize;
        }
        return list.remove(0);
    }
}