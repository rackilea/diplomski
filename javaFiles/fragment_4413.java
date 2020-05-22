public boolean checkCollectionForEqualObjects(Collection<SomeObject> collection) {
    Set<SomeObject> set = new HashSet<>();
    for (SomeObject object : collection) {
       set.add(object);
    }
    return set.size() == 1;
}