public static ArrayList<Integer> sorter(ArrayList<Integer> unsorted) {
ArrayList<Integer> sortedArray = new ArrayList<Integer>(unsorted.size());
while(!unsorted.isEmpty()) { //repeats until the unsorted list is empty
    int minval = unsorted.get(0);
    int removeIndex = 0;
    for(int i=1;i<unsorted.size();i++) 
        if (unsorted.get(i)<minval) {
            minval = unsorted.get(i);
            removeIndex = i;
        }
    sortedArray.add(minval);
    unsorted.remove(removeIndex);
    }
    return sortedArray;
}