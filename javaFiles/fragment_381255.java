public class So48840190Application {

    public static void main(String[] args) throws Exception {
        List<String> x = new LinkedList<>(Arrays.asList("A","AAB", "A"));
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext ec = new StandardEvaluationContext();
        ec.registerFunction("aToB", So48840190Application.class.getMethod("aToB"));
        Expression expression = parser.parseExpression(
                "stream().map(#aToB()).collect(T(java.util.stream.Collectors).toList())");
        System.out.println(expression.getValue(ec, x));
    }

    public static Function<String, String> aToB() {
        return s -> s.replaceAll("A", "B");
    }

}