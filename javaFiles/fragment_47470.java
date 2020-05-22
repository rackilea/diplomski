List<AnObjectType> getList(String key) {
     if (!mapOfList.containsKey(key)) {
     // This list might not end up being the one that gets returned, but
     // that's OK
         mapOfList.putIfAbsent(key, new CopyOnWriteArrayList<AnObjectType>());
     }
     return mapOfList.get(key);
}