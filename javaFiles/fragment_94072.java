public static class MapEntryConverter extends MapConverter {

public MapEntryConverter(Mapper mapper) {
    super(mapper);     
}

public boolean canConvert(Class clazz) {
    return ListMultimap.class.isAssignableFrom(clazz);
}

public void marshal(Object value, HierarchicalStreamWriter writer,
    MarshallingContext context) {

    ListMultimap<String, String> map = (ListMultimap<String, String>) value;
    for (String key : map.keys()) {
    writer.startNode(key);
    writer.setValue(map.get(key).get(0));
    writer.endNode();
    }
}


}