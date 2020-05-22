Map<Character, Long> freq = chars.stream()
   .collect(
        Collectors.groupingBy(
            x->x, 
            Collectors.counting()
        )
   );