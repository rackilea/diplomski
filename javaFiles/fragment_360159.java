public static void main(String[] args) {

    List<Integer> ids = Arrays.asList(5, 3, 2, 4, 1, 6);
    List<Foo> results = Arrays.asList(new Foo(1), new Foo(8), new Foo(2), new Foo(4), new Foo(5), new Foo(7));

    System.out.println("sortResults1: " + sortResults1(ids, results));
    System.out.println("sortResults2: " + sortResults2(ids, results));
}

private static List<Foo> sortResults1(List<Integer> ids, List<Foo> results) {
    Foo[] sortedResultsArray = new Foo[ids.size()];
    for (Foo result : results) {
        // look up the required position of this result's id 
        int pos = ids.indexOf(result.getId());
        if (pos >= 0) {
            sortedResultsArray[pos] = result;
        }
    }
    List<Foo> sortedResults = new ArrayList<>(Arrays.asList(sortedResultsArray));
    sortedResults.removeAll(Collections.singleton(null));
    return sortedResults;
}

private static List<Foo> sortResults2(List<Integer> ids, List<Foo> results) {
    Collections.sort(results, Comparator.comparingInt(item -> ids.indexOf(item.getId())));
    return results;
}