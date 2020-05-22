private static Integer[] theList;

static {
    theList = new Integer[4094];
    for (int i = 1; i < 4094; i++) {
        theList[i-1] = i;
    }
}