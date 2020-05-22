int[] position = {-1};

String firstNotHiddenItem = entries.stream()
        .peek(x -> position[0]++)  // increment every element encounter
        .filter("2"::equals)
        .findFirst()
        .get();

System.out.println(position[0]); // 2