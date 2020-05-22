Stream.of("a", "b", "c", "de", "f", "g", "h")
      .dropWhile(s -> {
          System.out.println("dropWhile: "+s);
          return s.length() <= 1;
      })
      .peek(s -> System.out.println("collecting "+s))
      .collect(Collectors.toList());