class CollectionsDefaultTypeResolverBuilder extends ObjectMapper.DefaultTypeResolverBuilder {

    private final Map<String, String> notValid2ValidIds = new HashMap<>();

    public CollectionsDefaultTypeResolverBuilder() {
        super(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
        this._idType = JsonTypeInfo.Id.CLASS;
        this._includeAs = JsonTypeInfo.As.PROPERTY;

        notValid2ValidIds.put("java.util.Collections$UnmodifiableRandomAccessList", ArrayList.class.getName());
        // add more here...
    }

    @Override
    protected TypeIdResolver idResolver(MapperConfig<?> config, JavaType baseType, Collection<NamedType> subtypes,
                                        boolean forSer, boolean forDeser) {
        return new ClassNameIdResolver(baseType, config.getTypeFactory()) {
            @Override
            protected String _idFrom(Object value, Class<?> cls, TypeFactory typeFactory) {
                String id = notValid2ValidIds.get(cls.getName());
                if (id != null) {
                    return id;
                }
                return super._idFrom(value, cls, typeFactory);
            }
        };
    }
}