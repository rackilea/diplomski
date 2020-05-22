public class ContiguousArray {

    public static <E> boolean isContiguous(E[][] array) {
        Map<E, Collection<Integer[]>> groupedPositions = groupLocations(array);

        return groupedPositions.values().stream().allMatch(ContiguousArray::allContiguous);
    }

    private static <E> Map<E, Collection<Integer[]>> groupLocations(E[][] array) {
        Map<E, Collection<Integer[]>> locations = new HashMap<>();

        for(int x = 0; x < array.length; x++) {
            for(int y = 0; y < array[x].length; y++) {

                Collection<Integer[]> knownIndices;
                Integer[] currentPosition = new Integer[] { x, y };
                E currentElement = array[x][y];

                if(locations.containsKey(currentElement)) {
                    knownIndices = locations.get(currentElement);
                } else {
                    knownIndices = new HashSet<>();

                    locations.put(currentElement, knownIndices);
                }
                knownIndices.add(currentPosition);
            }
        }
        return locations;
    }

    /**
     * @return true, if all of the provided indices have an adjacent index in
     *         the same collection. Also true, if the collection's size < 2.
     *         False, otherwise.
     */
    private static boolean allContiguous(Collection<Integer[]> indices) {
        return indices.stream().allMatch(thisIndex -> hasAdjacent(indices, thisIndex) || indices.size() < 2);
    }

    private static boolean hasAdjacent(Collection<Integer[]> indices, Integer[] thisIndex) {
        return indices.stream().anyMatch(thatIndex -> isAdjacent(thisIndex, thatIndex));
    }

    private static boolean isAdjacent(Integer[] thisIndex, Integer[] thatIndex) {
        return thatIndex != thisIndex && calculateDistance(thisIndex, thatIndex) < 2;
    }

    private static int calculateDistance(Integer[] indexA, Integer[] indexB) {
        int sum = 0;

        for (int i = 0; i < indexA.length; i++) {
            sum += Math.abs(indexA[i] - indexB[i]);
        }
        return sum;
    }
}