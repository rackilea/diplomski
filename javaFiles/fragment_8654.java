String[][] array = 
    IntStream.range(0, 3)
             .mapToObj(x -> IntStream.range(0, 3)
                                     .mapToObj(y -> String.format("%c%c", letter(x), letter(y)))
                                     .toArray(String[]::new))
             .toArray(String[][]::new);