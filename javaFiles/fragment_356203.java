class Connector implements FooRepository {
    private final Store<FooEntity> entityStore;

    //...

    void save(Foo foo) {
        FooDTO dto = new FooDTOAdapter(foo);
        FooEntity entity = new FooEntity(dto);
        entityStore.save(dto);
    }
}