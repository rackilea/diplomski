static class Interval {
    private final int min;
    private final int max;

    Interval(int min, int max) {
        this.min = min;
        this.max = max;
    }
}

private static String[] resequence(String[] input) {
    List<String> output = new ArrayList<>();
    if (input.length > 0) {
        List<Interval> queue = new ArrayList<>();
        queue.add(new Interval(0, input.length));
        while (!queue.isEmpty()) {
            Interval ival = queue.remove(0);
            int middle = (ival.min+ival.max)/2;
            output.add(input[middle]);
            if (middle > ival.min) {
                queue.add(new Interval(ival.min, middle));
            }
            if (middle+1 < ival.max) {
                queue.add(new Interval(middle+1, ival.max));
            }
        }
    }
    return output.toArray(new String[output.size()]);
}