public static void main(String[] args) throws Exception {
    List<Integer> integers = Arrays.asList(1, 3, 5, 9, 17);
    Map<String, Integer> differenceMap = new HashMap<>();

    for (int i = 0; i < integers.size(); i++) {
        int first = integers.get(i);

        for (int j = i + 1; j < integers.size(); j++) {
            int second = integers.get(j);

            int difference = second - first;
            int next = difference + second;
            if (integers.contains(next)) {
                differenceMap.put(first + " - " + second + " - " + next, difference);
            }
        }
    }

    differenceMap.keySet().forEach(System.out::println);

}