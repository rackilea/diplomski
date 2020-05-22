public class So48840190Application {

    public static void main(String[] args) throws Exception {
        List<String> x = new LinkedList<>(Arrays.asList("A","AAB", "A"));
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext ec = new StandardEvaluationContext();
        ec.registerFunction("replaceAll",
                So48840190Application.class.getMethod("replaceAll", String.class, String.class));
        ec.registerFunction("toLowerCase",
                So48840190Application.class.getMethod("toLowerCase"));
        Expression expression = parser.parseExpression(
                "stream().map(#replaceAll('A', 'B')).map(#toLowerCase()).collect(T(java.util.stream.Collectors).toList())");
        System.out.println(expression.getValue(ec, x));
    }

    public static Function<String, String> replaceAll(String from, String to) {
        return s -> s.replaceAll(from, to);
    }

    public static Function<String, String> toLowerCase() {
        return String::toLowerCase;
    }

}