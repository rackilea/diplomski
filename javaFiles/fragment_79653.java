private List<Object> retrieveContent(String strFilter, Consumer<Object> firstItemConsumer) {
    List<Object> list = new ArrayList<>();

    // Build the return...

    if(!list.isEmpty()) {
        firstItemConsumer.accept(list.get(0));
    }

    return list;
}