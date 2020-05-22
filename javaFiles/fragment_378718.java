import javax.script.*;

public class Main {
    public static int x = 10;
    public static void main(String[] args) throws Exception {
        ScriptEngine e = new ScriptEngineManager().
            getEngineByName("JavaScript");

        // access type object for Java class "Main" using Java.type
        e.eval("var M = Java.type('Main');");

        // access public static field 'x' of Main class
        e.eval("print(M.x)");

        // assign to public static field 'x' of Main class
        e.eval("M.x += 10;");

        // change is seen from Java
        System.out.println(Main.x);
    }
}