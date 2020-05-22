static ScriptEngineManager engineManager = new ScriptEngineManager();
static ScriptEngine engine = engineManager.getEngineByName("nashorn");

public static double eval(String expression, double n) throws NumberFormatException, ScriptException {
    String processedExpression = expression.replaceAll("n", Double.toString(n)); //Beware - this is a bad way of doing this
    return Double.parseDouble(engine.eval(processedExpression).toString())
}

public static void main(String... args) throws Throwable {
    System.out.println(eval("3*n+5", 10)); //Prints 35.0
}