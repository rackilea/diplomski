int sum(List<Integer> integers) {
    return sum(integers, 0);
}

int sum(List<Integer> integers, int sumSoFar) {
    if (integers.isEmpty())
        return sumSoFar;
    else
        return sum(
                integers.subList(1, integers.size()),
                sumSoFar + integers.get(0)
        );
}