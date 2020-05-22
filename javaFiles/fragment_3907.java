/**
 * Defines a deserializer for each and any used map class, as there is no inheritence support ind eserialization
 * @return
 */
@Produces
public DeserializerProvider createDeserializationProvider() {
    // Yeah it's not even a standard Jackson class, it'll be explained why later
    CustomDeserializerFactory factory = new MapAsArrayDeserializerFactory();
    List<Class<? extends Map>> classesToHandle = new LinkedList<>();
    classesToHandle.add(HashMap.class);
    classesToHandle.add(LinkedHashMap.class);
    classesToHandle.add(TreeMap.class);
    for(Class<? extends Map> c : classesToHandle) {
        addClassMappingFor(c, c, factory);
    }
    // and don't forget interfaces !
    addClassMappingFor(Map.class, HashMap.class, factory);
    addClassMappingFor(SortedMap.class, TreeMap.class, factory);
    return new StdDeserializerProvider(factory);
}

private void addClassMappingFor(final Class<? extends Map> detected, final Class<? extends Map> created, CustomDeserializerFactory factory) {
    factory.addSpecificMapping(detected, new MapAsArrayDeserializer() {

        @Override
        protected Map createNewMap() throws Exception {
            return created.newInstance();
        }
    });
}

// It's the same createMapper() method that was described upper
public @Produces ObjectMapper createMapper() {
    ObjectMapper jsonMapper = new ObjectMapper();
    // ....
    // and deserializer
    jsonMapper.setDeserializerProvider(createDeserializationProvider());
    return jsonMapper;
}