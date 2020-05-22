import javax.script.*;
import java.io.FileNotFoundException;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {

        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        //bind main instance
        Bindings bindings = engine.createBindings();
        bindings.put("main", new main());
        engine.setBindings(bindings, ScriptContext.GLOBAL_SCOPE);

        // evaluate JavaScript code from given file - specified by first argument
        engine.eval(new java.io.FileReader("l.js"));

    }

    public void makeObject(String s) {
        System.out.println(s);
    }
}