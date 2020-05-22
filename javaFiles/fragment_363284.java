final int listSize = list.size();
E[][] darr = new E[listSize][];
for(int i = 0; i < listSize; i++) {
    ArrayList<E> sublist = list.get(i);
    final int sublistSize = sublist.size();
    darr[i] = new E[sublistSize];
    for(int j = 0; j < sublistSize; j++) {
        darr[i][j] = sublist.get(j);
    }
}