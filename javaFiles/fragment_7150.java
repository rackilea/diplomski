Integer[] given = {0,0,1,22,11,22,22,11,44,555,55,66,77,88,99};

Map<Integer, Long> frequencyMap = Arrays.stream(given)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
Arrays.sort(given,
    Comparator.<Integer>comparingLong(frequencyMap::get)
       .thenComparing(Comparator.naturalOrder()));

System.out.println(Arrays.toString(given));