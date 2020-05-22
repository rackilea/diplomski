import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class RhinoExample {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine rhino = manager.getEngineByName("JavaScript");

        Double result = (Double) rhino.eval("1 + 2");
        Integer i = result.intValue();
        System.out.println(i);
    }
}