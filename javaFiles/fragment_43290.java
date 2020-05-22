/* Transform Stream of words like 2, a, b, 3, c, d, e to
   Stream of lists like [a, b], [c, d, e] */
public static StreamEx<List<String>> records(StreamEx<String> input) {
    return input.headTail((count, tail) -> 
        makeRecord(tail, Integer.parseInt(count), new ArrayList<>()));
}

private static StreamEx<List<String>> makeRecord(StreamEx<String> input, int count, 
                                                 List<String> buf) {
    return input.headTail((head, tail) -> {
        buf.add(head);
        return buf.size() == count 
                ? records(tail).prepend(buf)
                : makeRecord(tail, count, buf);
    });
}