import javax.script.*;

public class Main {
   public static void main(String[] args) throws Exception {
       ScriptEngineManager m = new ScriptEngineManager();
       ScriptEngine e = m.getEngineByName("nashorn");
       e.put("Vec", java.util.Vector.class); // replace it with any Class object
       e.eval("var T = Vec.static; var obj = new T()"); // create new Vector
       e.eval("print(obj.getClass())");
   }
}