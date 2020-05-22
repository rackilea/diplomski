Map<String,BiFunction<Integer,Integer,Integer>> operators = new HashMap<>();
operators.put("+", (a,b) -> a + b);
operators.put("-", (a,b) -> a - b);
operators.put("*", (a,b) -> a * b);

...

// get a, b, op from ui
ui.output(operators.get(operator).apply(a,b));