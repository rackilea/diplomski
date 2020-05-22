Pattern pattern = Pattern.compile("[.]");

Arrays.asList("Stack.Overflow")
      .stream()
      .map(pattern::split)
      .collect(Collectors.toMap(s -> s[0], s -> s[1]));