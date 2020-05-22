public class CompileScript {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = engineManager.getEngineByName("js");

        //cast to Compilable engine, this is safe for Rhino
        Compilable c = (Compilable) scriptEngine;    
        CompiledScript script = c.compile("print('Hello World')");    //compile

        script.eval();
    }
}