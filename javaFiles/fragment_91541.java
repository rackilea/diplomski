List<Integer> list = Arrays.asList(3,10,17,9,20,55,40,30);

list.stream()
    .sorted(Comparator.comparing((Integer i) -> i%10==0)
                      .thenComparing(Comparator.naturalOrder()))
    .forEach(System.out::println);