boolean hasSumEqualTo(List<Integer> list, int sum) {
    if (list.isEmpty())
        return sum == 0;
    int first = list.remove(0);
    return hasSumEqualTo(list, sum) || hasSumEqualTo(list, sum - first);
}