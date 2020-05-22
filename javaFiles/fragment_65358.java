public void test() {
    final Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    final Collection<Integer> arrayList = new ArrayList<>(numbers);
    final Collection<Integer> arrayList2 = getBiggerThan(arrayList, 6);
    System.out.println(arrayList2);
    System.out.println(arrayList2.getClass());
    System.out.println();

    final Collection<Integer> set = new HashSet<>(arrayList);
    final Collection<Integer> set2 = getBiggerThan(set, 6);
    System.out.println(set2);
    System.out.println(set2.getClass());
    System.out.println();

    // This does not work as Arrays.asList() is of a type
    // java.util.Arrays$ArrayList which does not provide a nullary constructor
    final Collection<Integer> numbers2 = getBiggerThan(numbers, 6);
}