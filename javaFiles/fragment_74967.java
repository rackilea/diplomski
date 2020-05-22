public static void main(String[] args) {
    List<Integer> list = IntStream.range(10, 20)
            .boxed()
            .collect(Collectors.toList());
    List<Integer> groups[] = createGroups(list, 4);
    for (List<Integer> group : groups) {
        System.out.println(group);
    }
}

public static List<Integer>[] createGroups(List<Integer> list, int maximumPerGroup) {
    int numberOfGroups = list.size() / maximumPerGroup;
    if (list.size() % maximumPerGroup > 0) numberOfGroups++;
    List<Integer> groups[] = new ArrayList[numberOfGroups];
    for (int i = 0; i < list.size(); i++) {
        if (groups[i % numberOfGroups] == null) groups[i % list.size()] = new ArrayList<>();
        groups[i % numberOfGroups].add(list.get(i));
    }
    return groups;
}