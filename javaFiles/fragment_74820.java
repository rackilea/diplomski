Map<String, Object> leftFlatMap = FlatMapUtil.flatten(leftMap);
Map<String, Object> rightFlatMap = FlatMapUtil.flatten(rightMap);

MapDifference<String, Object> difference = Maps.difference(leftFlatMap, rightFlatMap);

System.out.println("Entries only on the left\n--------------------------");
difference.entriesOnlyOnLeft()
          .forEach((key, value) -> System.out.println(key + ": " + value));

System.out.println("\n\nEntries only on the right\n--------------------------");
difference.entriesOnlyOnRight()
          .forEach((key, value) -> System.out.println(key + ": " + value));

System.out.println("\n\nEntries differing\n--------------------------");
difference.entriesDiffering()
          .forEach((key, value) -> System.out.println(key + ": " + value));