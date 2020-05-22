int[][] input = {{1,2,3},
                 {1,0,3},
                 {1,2,3},
                 {5,2,6},
                 {5,2,6},
                 {5,2,6}};
Map<IntArray, Long> map = Arrays.stream(input).map(IntArray::new)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
map.entrySet().forEach(System.out::println);