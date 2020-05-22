List<String> list = new ArrayList<>();
list.addAll(getSomeItems());
// some operations for a which an array-based list is most efficient
// ...

list = new LinkedList<>();
list.addAll(getSomeDifferentItems());
// some operations for a which a linked list is most efficient
// ...