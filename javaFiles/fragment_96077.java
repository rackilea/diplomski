public class NoRepeatCollector {
    public static <E> Collector<E, ?, List<E>> get() {
        return Collector.of(ArrayList::new,
                            NoRepeatCollector::addNoRepeat,
                            NoRepeatCollector::combineNoRepeat);
    }
    private static <E> void addNoRepeat(List<E> list, E value) {
        if (list.isEmpty() || ! list.get(list.size() - 1).equals(value))
            list.add(value);
    }
    private static <E> List<E> combineNoRepeat(List<E> left, List<E> right) {
        if (left.isEmpty())
            return right;
        if (! right.isEmpty())
            left.addAll(left.get(left.size() - 1).equals(right.get(0))
                        ? right.subList(1, right.size()) : right);
        return left;
    }
}