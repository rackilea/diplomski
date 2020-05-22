ScriptEngineManager mgr = new ScriptEngineManager();
ScriptEngine engine = mgr.getEngineByName("JavaScript");
String foo = "(3+4)*7/2";
double result=0;
try {
    /*
    It seems that (on some platforms) this results in a java.lang.RuntimeException 
    because of converting Object to double, so let's replace it with
    Double.doubleValue()
    */
    //result = (double) (engine.eval(foo));
    result = ((Double) (engine.eval(foo))).doubleValue(); //result = 24.5
} catch (ScriptException e) {
    //handle exception here
}