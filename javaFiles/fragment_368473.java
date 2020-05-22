String javaScriptExpression = "sayHello(name);";
Reader javaScriptFile = new StringReader(
    "function sayHello(name) {\n"
        + "    println('Hello, '+name+'!');\n" + "}");

ScriptEngineManager factory = new ScriptEngineManager();
ScriptEngine engine = factory
    .getEngineByName("JavaScript");
ScriptContext context = engine.getContext();
context.setAttribute("name", "JavaScript",
    ScriptContext.ENGINE_SCOPE);

engine.eval(javaScriptFile);
engine.eval(javaScriptExpression);