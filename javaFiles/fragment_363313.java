Set<IdType> idSet = new HashSet<>(ids);
for (ObjType o : obj) {
    if (idSet.contains(o.getChatId())) {
        // ...
    }
}