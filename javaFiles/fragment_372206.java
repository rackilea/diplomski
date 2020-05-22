int[] input = new int[]{5, 5, 5, 3, 2};
List<Integer> matches = new ArrayList<Integer>(input.length);
for (int index = 1; index < input.length; index++) {
    if (input[index] == input[index - 1]) {
        // We've not added the first element yet
        if (matches.isEmpty()) {
            matches.add(input[index]);
        }
        matches.add(input[index]);
    } else {
        // No point going forward
        break;
    }
}
System.out.println(matches);