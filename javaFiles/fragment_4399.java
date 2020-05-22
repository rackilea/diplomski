public static int[] range(int[] range1, int[] range2) {
    int start = Math.max(range1[0], range2[0]);
    int end = Math.min(range1[1], range2[1]);
    if (start < end) {
        return new int[]{start, end};
    } else if (start == end) {
        return new int[]{start};
    } else {
        return null;
    }
}