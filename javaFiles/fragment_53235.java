import javax.script.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine e = m.getEngineByName("nashorn");
        e.eval(new FileReader(args[0])); 
        Thing th = new Thing();
        // script evaluated is expected to 'register' func, foo
        // call those functions from java
        th.executeFunction("func", "arg1", "arg2");
        th.executeFunction("foo", "bar", "j");
    }
}