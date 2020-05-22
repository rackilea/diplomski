public static void main(String[] args) {
    System.out.println(getMap(Arrays.asList("a", "a", "b")));
    // prints "{a=[foo:a, foo:a], b=[foo:b]}"
}

public static Map<String, List<String>> getMap(List<String> items) {
    return items.stream()
                .map(item -> getNewMap(item))
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (l1, l2) -> { List<String> l = new ArrayList<>(l1); l.addAll(l2); return l; }
                ));
}

public static Map<String, List<String>> getNewMap(String item) {
    Map<String, List<String>> map = new HashMap<>();
    map.put(item, Arrays.asList("foo:" + item));
    return map;
}