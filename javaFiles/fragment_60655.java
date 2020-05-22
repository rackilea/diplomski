private static List<Integer[]> splitOrderedDurationsIntoIntervals(Integer[] durations, int numberOfIntervals) {

    int sizeOfSmallSublists = durations.length / numberOfIntervals;
    int sizeOfLargeSublists = sizeOfSmallSublists + 1;
    int numberOfLargeSublists = durations.length % numberOfIntervals;
    int numberOfSmallSublists = numberOfIntervals - numberOfLargeSublists;

    List<Integer[]> sublists = new ArrayList(numberOfIntervals);
    int numberOfElementsHandled = 0;
    for (int i = 0; i < numberOfIntervals; i++) {
        int size = i < numberOfSmallSublists ? sizeOfSmallSublists : sizeOfLargeSublists;
        Integer[] sublist = new Integer[size];
        System.arraycopy(durations, numberOfElementsHandled, sublist, 0, size);
        sublists.add(sublist);
        numberOfElementsHandled += size;
    }
    return sublists;
}