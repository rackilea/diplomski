String sql = IntStream.range(0, selectFields.size())
    .mapToObj(i -> uuidFunction.get(i) != null 
         ? uuidFunction.get(i) + "(" + selectFields.get(i) + ")"
         : selectFields.get(i)
    )
    .collect(Collectors.joining(", ", "SELECT ", " FROM test_table");