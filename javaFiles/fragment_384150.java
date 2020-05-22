if (linkedList.isEmpty()) return linkedList;

//create a map with previousElementId as Key, T as Object
Map<Integer, T> map = collection.stream().collect(
            Collectors.toMap(T::getPreviousElementId, Function.identity()));

//we fetch nodes using the current ID as the key
T node = map.get(linkedList.getLast().getId());
while(node != null) {
    linkedList.add(node);
    node = map.get(node.getId());
}