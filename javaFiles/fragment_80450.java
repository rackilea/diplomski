public static void main(String[] args) throws Exception {
    test(false, false);
    test(false, true );
    test(true , false);
    test(true , true );
}
private static void test(boolean in1, boolean in2) throws ScriptException {
    ScriptEngineManager engineManager = new ScriptEngineManager();
    ScriptEngine engine = engineManager.getEngineByName("JavaScript");
    Bindings vars = engine.getBindings(ScriptContext.ENGINE_SCOPE);
    vars.put("in1", in1);
    vars.put("in2", in2);
    boolean result = (boolean) engine.eval("in1 && in2");
    System.out.println(result);
}