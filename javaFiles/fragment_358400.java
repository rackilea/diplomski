Set<String> allowed = new HashSet<>(Arrays.asList("correct", "invalid"));
Map<String, Long> result = 
    values.flatMap(Set::stream)
          .map(s -> allowed.contains(s) ? s : "other")
          .collect(Collectors.groupingBy(Function.identity(), 
                                         Collectors.counting()));