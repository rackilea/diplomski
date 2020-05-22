public static List<Integer> difference(List<Integer> leftList, List<Integer> rightList) {
    if(null == leftList || null == rightList) {
        throw new IllegalArgumentException("Can't have any null parameters.");
    }
    if(leftList.size() < rightList.size()) {
        throw new IllegalArgumentException("Left shouldn't be larger than right.");
    }

    List<Integer> result = new LinkedList<>();
    int i = 0;
    int j = 0;
    while (i < leftList.size()) {
        while (j < rightList.size()) {
            Integer leftElement = leftList.get(i);
            Integer rightElement = rightList.get(j);
            if(rightElement.compareTo(leftElement) <= 0) {
                // less than or equal to.  Skip.
                i += 1;
                j += 1;
                break;
            }
            if(rightElement.compareTo(leftElement) > 0) {
                // The right-hand side is greater than the left hand side.
                // Add it to the results.
                result.add(leftElement);
                i++;
                break;
            }
            j++;
        }
    }
    return result;
}