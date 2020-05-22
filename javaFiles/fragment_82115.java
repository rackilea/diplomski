private static Map<String, Object> dumpValues(Stuff stuff) throws IllegalAccessException {
    Map<String, Object> map = new HashMap<String, Object>();
    for (Field field : stuff.getClass().getDeclaredFields()) {
        map.put(field.getName(), field.get(stuff));
    }
    return map;
}