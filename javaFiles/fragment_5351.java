public void greeting(String name)
{
    ExpressionParser parser = new SpelExpressionParser();
    Expression exp = parser.parseExpression(name);
    String message = exp.getValue(Integer.class).toString();

    System.out.println("Hello and welcome to Spring: " + message);
}