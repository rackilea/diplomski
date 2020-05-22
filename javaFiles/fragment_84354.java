import java.util.Map.Entry;

            charMap.entrySet().stream()
                    .collect(Collectors.groupingBy(Entry<Character, Integer>::getValue))
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparing(
                        Entry<Integer, List<Entry<Character, Integer>>>::getKey)
                        .reversed())
                    .limit(2) // To highest frequencies
                    .map(e -> e.getValue())
                    .flatMap(List<Entry<Character, Integer>>::stream)
                    .sorted(Comparator.comparing(Entry<Character, Integer>::getKey))
                    .forEach(entry -> System.out.printf("# '%c' : %d%n",
                                      entry.getKey(), entry.getValue()));