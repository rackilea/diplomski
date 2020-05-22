public class ListSum {

    public static void main(String[] args) {
        subsetsThatSumTo(18, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).forEach(System.out::println);
    }

    public static List<List<Integer>> subsetsThatSumTo(int total, List<Integer> list) {
        List<List<Integer>> result = new ArrayList<>();
        if (list.stream().mapToInt(n -> n).sum() == total) {
            result.add(new ArrayList<>(list));
        } else if (!list.isEmpty()) {
            subsetsThatSumTo(total - list.get(0), list.subList(1, list.size())).forEach(result::add);
            result.forEach(l -> l.add(0, list.get(0)));
            subsetsThatSumTo(total, list.subList(1, list.size())).forEach(result::add);
        }
        return result;
    }
}