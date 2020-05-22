Map<String, String> pets = new HashMap<>();
    pets.put("dog", "DOG");
    pets.put("cat", "CAT");
    Integer a = 10;
    Integer b = 20;

    Map<String, Object> params = new HashMap<>();
    params.put("$a", a);
    params.put("$b", b);
    params.put("$map", pets);
    params.put("$key", "dog");

    CompiledExpression expression = new ExpressionCompiler("$a > 0 && $b > 0 && $map.containsKey($key)").compile();
    System.out.println(MVEL.executeExpression(expression, params));
    System.out.println(MVEL.eval("$a > 0 && $b > 0 && $map.containsKey($key)", params));