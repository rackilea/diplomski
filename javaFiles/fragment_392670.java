public static void main(String[] args) {

    List<List<String>> powerSet = new LinkedList<List<String>>();

    for (int i = 1; i <= args.length; i++)
        powerSet.addAll(combination(Arrays.asList(args), i));

    System.out.println(powerSet);
}

public static <T> List<List<T>> combination(List<T> values, int size) {

    if (0 == size) {
        return Collections.singletonList(Collections.<T> emptyList());
    }

    if (values.isEmpty()) {
        return Collections.emptyList();
    }

    List<List<T>> combination = new LinkedList<List<T>>();

    T actual = values.iterator().next();

    List<T> subSet = new LinkedList<T>(values);
    subSet.remove(actual);

    List<List<T>> subSetCombination = combination(subSet, size - 1);

    for (List<T> set : subSetCombination) {
        List<T> newSet = new LinkedList<T>(set);
        newSet.add(0, actual);
        combination.add(newSet);
    }

    combination.addAll(combination(subSet, size));

    return combination;
}