ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("javascript");

try {
    String result = engine.eval(stringEquation).toString();
    System.out.println("Result: "+result);
} 
catch (ScriptException se) {
    // Handle error
}