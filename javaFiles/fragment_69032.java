String[] ops = new String[] { "+", "-", "*", "/" };
    List<String> opsList = Arrays.asList(ops);
    String[][] combinations = opsList.stream()
                                .flatMap(x -> opsList.stream().flatMap(y -> opsList.stream().map(z -> new String[] { x, y, z })))
                                .toArray(String[][]::new);
    System.out.println(Arrays.deepToString(combinations));