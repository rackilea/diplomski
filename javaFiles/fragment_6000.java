private ScriptEngineManager manager = new ScriptEngineManager();
private ScriptEngine engine = manager.getEngineByName("JavaScript");

engine.eval(Files.newBufferReader("PATH TO THE JAVASCRIPT FILE", StandardCharsets.UTF_8));

Object result = engine.get("cars"); //Variable in the javascript File

if(result instanceof Map){
result = (Map<String,Object>) result;
}