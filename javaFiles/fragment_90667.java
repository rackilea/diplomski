// Better use a `List`. It is more generic and it also receives an `ArrayList`.
public static double average(List<Integer> list) {
    // 'average' is undefined if there are no elements in the list.
    if (list == null || list.isEmpty())
        return 0.0;
    // Calculate the summation of the elements in the list
    long sum = 0;
    int n = list.size();
    // Iterating manually is faster than using an enhanced for loop.
    for (int i = 0; i < n; i++)
        sum += list.get(i);
    // We don't want to perform an integer division, so the cast is mandatory.
    return ((double) sum) / n;
}