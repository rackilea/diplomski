protected List<Map<String, Object>> populate(List<SomeObject> someObjects, String string) {
    Stream<SomeObject> stream = someObjects.stream();
    if (string != null) {
         stream = stream.filter(s -> string.equals(s.getName()));
    }
    return stream.map(someObject -> {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("someCustomField1", someObject.Field1());
        map.put("someCustomField2", someObject.Field2());
        map.put("someCustomField3", someObject.Field3());
        return map;
    }).collect(Collectors.toList());
}