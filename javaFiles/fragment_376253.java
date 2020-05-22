Map<String, Long> bag =
   Pattern.compile(" ")
          .splitAsStream("one o'clock two o'clock three o'clock rock")
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
Map<String, Long> sortedBag = 
    bag.entrySet()
       .stream()
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .collect(Collectors.toMap(
           Map.Entry::getKey,
           Map.Entry::getValue,
           (v1, v2) -> { throw new IllegalStateException(); },
           LinkedHashMap::new
       ));