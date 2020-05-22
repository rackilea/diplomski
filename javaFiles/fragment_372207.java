int[] input = new int[]{5, 5, 5, 3, 3};
List<List<Integer>> allMatches = new ArrayList<>(5);
List<Integer> matches = null;
for (int index = 1; index < input.length; index++) {
    if (input[index] == input[index - 1]) {
        if (matches == null) {
            matches = new ArrayList<Integer>(input.length);
            // We need the previous value
            matches.add(input[index]);
        }
        matches.add(input[index]);
    } else {
        if (matches != null) {
            allMatches.add(matches);
        }
        matches = null;
    }
}
if (matches != null) {
    allMatches.add(matches);
}
System.out.println(allMatches);