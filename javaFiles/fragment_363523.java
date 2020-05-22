private int findIndex(String id) {
    OptionalInt index = IntStream.rangeClosed(0, ids.length-1)
                                 .filter(i -> ids[i].equalsIgnoreCase(id))
                                 .findFirst();
    if(index.isPresent()) {
        int i = index.getAsInt();
        System.out.println("The index of this student is " + i);
        return i;
    }
    System.out.println(-1);
    return -1;
}