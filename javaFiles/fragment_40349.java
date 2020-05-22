static void overwrite(StringBuffer sb, int dst, int srcFrom, int srcTo) {
    for (int i = srcFrom; i < srcTo; i++) {
        sb.setCharAt(dst++, sb.charAt(i));
    }
}
static int safeGet(int[][] arr, int index, int defaultValue) {
    return (index < arr.length) ? arr[index][0] : defaultValue;
}
static void removeIntervals(StringBuffer sb, int[][] intervals) {
    int dst = safeGet(intervals, 0, 0);
    int removed = 0;
    for (int i = 0; i < intervals.length; i++) {
        int start = intervals[i][0];
        int end   = intervals[i][1];
        int nextStart = safeGet(intervals, i+1, sb.length());
        overwrite(sb, dst, end, nextStart);
        removed += end - start;
        dst += nextStart - end;
    }
    sb.setLength(sb.length() - removed);
}