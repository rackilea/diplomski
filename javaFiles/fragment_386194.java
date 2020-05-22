public class MapperProvider<T> implements Provider<Mapper<T>> {
    private final MappingManager mappingManager;
    private final TypeLiteral<T> type;

    @Inject
    public MapperProvider(MappingManager mappingManager, TypeLiteral<T> type) {
        this.mappingManager = mappingManager;
        this.type = type;
    }

    @Override
    public Mapper<T> get() {
        return mappingManager.mapper(type.getRawType());
    }
}

bind(new TypeLiteral<Mapper<Foo>>(){})
       .toProvider(new TypeLiteral<MapperProvider<Foo>>(){});