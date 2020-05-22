import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class Jsr223Binding {


    private Jsr223Binding() throws ScriptException {
        System.setProperty("org.jruby.embed.localvariable.behavior", "transient");
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("jruby");
        ScriptContext ctx1 = new SimpleScriptContext();
        ScriptContext ctx2 = new SimpleScriptContext();
        engine.eval("$foo = 5\nputs $foo", ctx1);
        engine.eval("puts $foo", ctx2);
    }

    public static void main(String[] args) throws ScriptException {
        new Jsr223Binding();
    }
}