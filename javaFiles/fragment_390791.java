public static SortableArray<Integer> createSortableArrayFromInts(int[] theList)
{
    Integer[] temp = new Integer[theList.length];   
    for(int i = 0; i < theList.length; i++) {
        temp[i] = Integer.valueOf(theList[i]);
    }
    return new SortableArray<Integer>(temp);
}