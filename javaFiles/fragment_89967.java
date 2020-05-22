private static int getUnits(List<String> list1values, List<String> list2values) {
    int highestHit = 0;
    int highestUnits = 0;

    for (String listValue : list2values) {
        int[] currentHitsArray = getAdditionalUnits(list1values, listValue);
        int currentHit = currentHitsArray[0];
        int currentUnits = currentHitsArray[1];

        if (currentHit > highestHit) {
            highestHit = currentHit;
            highestUnits = currentUnits;
        } else if (currentHit == highestHit && currentUnits > highestUnits) {
            highestUnits = currentUnits;
        }
    }
    return highestUnits;
}