ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("JavaScript");
String expression = textField.getText();

// Between here...
        expression = expression.
                replace("sin", "Math.sin").
                replace("cos", "Math.cos").
                replace("tan", "Math.tan").
                replace("sqrt", "Math.sqrt").
                replace("log", "Math.log").
                replace("pi", "Math.PI");
// And so on...

System.out.println(engine.eval(foo));