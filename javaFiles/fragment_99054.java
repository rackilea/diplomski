List<Integer> values =
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

      int x = 1;
      while (x < 100_000) {
         for (int k = 15 * x; k <= 100 * x; k += 5 * x) {
            values.add(k);
         }
         x *= 10;
      }

      values.forEach(System.out::println);