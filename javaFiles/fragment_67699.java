void printSubsetsThatSumTo(String current, List<Integer> list, int sum) {
    if (list.isEmpty()) {
        if (sum == 0)
            System.out.println(current);
    } else {
        int first = list.remove(0);
        printSubsetsThatSumTo(current, list, sum);
        printSubsetsThatSumTo(current + " " + first, list, sum - first);
    }
}