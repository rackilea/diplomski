HashSet<Long> ids = new HashSet<Long>();
for (ObjectA objA: listA) {
    list.add(objA);
    ids.add(objA.getId());
}

for (ObjectB objB: listB) {
    if (!ids.contains(objB.getId())) {
        ids.add(objB.getId());
        list.add(objB);
    }
}