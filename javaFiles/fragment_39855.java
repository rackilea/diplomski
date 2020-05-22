List<Integer> arr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
Map<Boolean, List<Integer>> result = arr.stream()
    .collect(Collectors.partitioningBy(i -> i % 2 == 0));
List<Integer> evenArr = result.get(true);
List<Integer> oddArr = result.get(false);
System.out.println("evenArr=" + evenArr);
System.out.println("oddArr=" + oddArr);