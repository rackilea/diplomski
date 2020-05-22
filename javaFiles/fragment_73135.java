List<MyObject> findByIdIn(Set<String> ids);

default Map<String, Optional<MyObject>> mapByIdIn(Set<String> ids) {
    Map<String, Optional<MyObject>> found = findByIdIn(ids)
            .stream()
            .collect(Collectors.toMap(MyObject::getId, Optional::of));
    ids.stream()
       .filter(id -> !found.containsKey(id))
       .forEach(id -> found.put(id, Optional.empty()));
    return found;
}