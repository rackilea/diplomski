Map<String, Brand> map = brands
     .stream()
     .collect(
          Collectors.toMap(
              Brand::getName, // the key
              Function.identity(), // the value
              (first, second) -> first, // how to handle duplicates
              () -> new TreeMap<String, Brand>(String.CASE_INSENSITIVE_ORDER))); // supply the map implementation