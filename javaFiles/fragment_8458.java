public static void main(String[] args)
{
    /* Initialization */
    int min = 1;
    int max = 1000;
    final Set<Integer> solutions = new HashSet<>();
    final Set<Integer> items = new HashSet<>();
    Collections.addAll(items, 3,6,7);


    /* Solution */
    items.forEach(element -> solutions.addAll(findMultiples(element, min, max)));

    System.out.println("Total quantity: " + solutions.size());
    solutions.forEach(System.out::println);
}

private static Collection<Integer> findMultiples(int element, int min, int max) {
    if (min % element != 0) {
        min = element * (min / element + 1);
    }
    final Collection<Integer> solutions = new ArrayList<>();
    for (int i = min; i < max; i+=element) {
        solutions.add(i);
    }

    return solutions;
}