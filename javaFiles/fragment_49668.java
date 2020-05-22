private static List<?> match(String expressionString, String text) {
    Expression expression;
    ParameterTypeRegistry parameterTypeRegistry = new ParameterTypeRegistry(Locale.ENGLISH);
    expression = new CucumberExpression(expressionString, parameterTypeRegistry);
    List<Argument<?>> args = expression.match(text);
    if (args == null) {
        return null;
    } else {
        List<Object> list = new ArrayList<>();
        for (Argument<?> arg : args) {
            Object value = arg.getValue();
            list.add(value);
        }
        return list;
    }
}