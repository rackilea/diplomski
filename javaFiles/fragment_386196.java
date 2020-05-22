for (Type object: Objects) {
    map.put(object.obj.getId() , object);
}
for (Entry entry: map.entrySet()) {
    // should be same order as inserted if LinkedHashMap is used
}