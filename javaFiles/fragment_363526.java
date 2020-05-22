int coveringPrefixIndex(final int[] arr) {
    Map<Integer,Integer> indexes = new HashMap<Integer,Integer>();
    // start from the back
    for(int i = arr.length - 1; i >= 0; i--) {
        indexes.put(arr[i],i);
    }
    // now find the highest value in the map
    int highestIndex = 0;
    for(Integer i : indexes.values()) {
        if(highestIndex < i.intValue()) highestIndex = i.intValue();
    }
    return highestIndex;
}