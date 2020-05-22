public static void main(String[] args) throws IOException {
    List<Long> resultlist = Arrays.asList(0L, 0L, 0L, 0L, 0L, 0L);

    calculateList(resultlist, Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
    calculateList(resultlist, Arrays.asList(2L, 1L, 3L, 4L, 6L, 2L));

    System.out.println(Arrays.toString(resultlist.toArray()));
}

private static void calculateList(List<Long> resultList, List<Long> input) {
    for (int i = 0; i < resultList.size(); i++) {
        resultList.set(i, resultList.get(i) + input.get(i));
    }
}