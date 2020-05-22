List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

List<Integer> test2 = test.stream()
                          .map(i -> i % 2 == 0 ? i : 0)
                          .collect(toList());
test2.forEach(System.out::println);