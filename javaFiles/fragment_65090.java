static void deepCopy(List<List<Integer>> input) {
    List<List<Integer>> output = new ArrayList<>(input.size());
    for (List<Integer> inner : input)
        output.add(new ArrayList<>(inner));
    return output;
}