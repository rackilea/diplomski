public final class Utility {
    private Utility() { }

    public static List<Integer> modifyAllButLast(List<Integer> list) {
        return Stream.concat(
                l.subList(0, l.size() - 1).stream().map(i -> i - 2),
                Stream.of(l.get(l.size() - 1)))
            .collect(Collectors.toList());
    }
}