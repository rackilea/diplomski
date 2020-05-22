return messages.stream()
               .collect(groupingBy(Function.identity(), LinkedHashMap::new, summingInt(e -> 1)))
               .entrySet()
               .stream()
               .map(e -> e.getKey()+(e.getValue() == 1 ? "" : " (" + e.getValue() +" times)"))
               .collect(toList());