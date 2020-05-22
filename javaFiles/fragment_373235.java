public class ListSum {

    public static void main(String[] args) {
        System.out.println(subsetThatSumTo(18, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    public static List<Integer> subsetThatSumTo(int total, List<Integer> list) {
        if (list.stream().mapToInt(n -> n).sum() == total)
            return new ArrayList<>(list);
        if (list.isEmpty())
            return null;
        List<Integer> result = subsetThatSumTo(total - list.get(0), list.subList(1, list.size()));
        if (result != null) {
            result.add(0, list.get(0));
            return result;
        } else {
            return subsetThatSumTo(total, list.subList(1, list.size()));
        }
    }
}