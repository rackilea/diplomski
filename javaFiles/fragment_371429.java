//only to be used if list is sorted (a priori)
public int closestValue (List<Integer> list, int value) {
    int index = Collections.binarySearch(list,value);
    if(index < 0) {
        index = ~index-1;
    }
    return list.get(index);
}