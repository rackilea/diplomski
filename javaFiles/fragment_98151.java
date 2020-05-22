public static void main(String[] args) {
    String[] input = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
        "l", "m", "n", "o"};
    String[] output = resequence(input);
    System.out.println(Arrays.asList(output));
}

private static String[] resequence(String[] input) {
    List<String> output = new ArrayList<>();
    for (int depth = 0; output.size() != input.length; ++depth) {
        iteration(input, 0, input.length, depth, 0, output);
    }
    return output.toArray(new String[output.size()]);
}

private static void iteration(String[] input, int min, int max,
        int target, int depth, List<String> output) {
    if (min < max) {
        int middle = (min+max)/2;
        if (target == depth) {
            output.add(input[middle]);
        } else {
            iteration(input, min, middle, target, depth+1, output);
            iteration(input, middle+1, max, target, depth+1, output);
        }
    }
}