// With lists : no need to determine size of both arrays before.
List<Integer> positivesList = new ArrayList<>();
List<Integer> negativesList = new ArrayList<>();

for(int value : source) {
    if (value >= 0) {
        positivesList.add(value);
    } else {
        negativesList.add(value);
    }
}

Integer[] positivesCase2 = positivesList.toArray(new Integer[positivesList.size()]);
Integer[] negativesCase2 = negativesList.toArray(new Integer[negativesList.size()]);

System.out.println(Arrays.toString(positivesCase2)); // [4, 6, 2]
System.out.println(Arrays.toString(negativesCase2)); // [-3, -1]