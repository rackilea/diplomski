Map<String, IntBinaryOperator> operators = new HashMap<>();

operators.put("+", (a, b) -> a + b);
operators.put("-", (a, b) -> a - b);
operators.put("*", (a, b) -> a * b);
operators.put("/", (a, b) -> a / b);

...

return operators.get(op).apply(args[0], args[1]);