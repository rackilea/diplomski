import javax.script.*;
import java.net.URL;
import jdk.nashorn.api.scripting.URLReader;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine e = m.getEngineByName("nashorn");
        e.eval(new URLReader(Main.class.getResource("test.js")));
    }
}