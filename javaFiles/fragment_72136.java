List<?> result = lib.get();
Iterator<?> iterator = result.iterator();
while(iterator.hasNext()){
    Object next = iterator.next();
    // -------------------
    List<Integer> list = (List<Integer>) next;
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    // -------------------
}