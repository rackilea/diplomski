ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine se = mgr.getEngineByName("JavaScript");

try {
    se.eval("var x;var a,b,c,d;var y = \"wow\";var z = y+'x';");
    Bindings bindings = se.getBindings(ScriptContext.ENGINE_SCOPE);
    System.out.println(bindings.keySet());
}
catch (ScriptException e) {
    //e.printStackTrace();
}