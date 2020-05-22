private static List<Integer> theList;

static {
    theList = new ArrayList(4094);
    for (Integer i = 0; i < 4094; i++) {
        theList.add(i+1);
    }
}