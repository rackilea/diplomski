input.stream()
     .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
     .values()
     .stream()
     .mapToLong(i -> i/2)
     .sum();