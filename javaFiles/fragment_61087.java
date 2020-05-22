class ExampleObject {
    long id;
    String name;
    String description;
    int version;
    long parentId;

    public ExampleObject(final long id, final String name, final String description, final int version, final long parentId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.parentId = parentId;
    }
}