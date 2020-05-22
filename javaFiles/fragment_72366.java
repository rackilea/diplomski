import javax.script.*;
import java.util.function.Function;

public class Main {
   // a Function implementation
   private static class MyFunc implements Function<String, Void> {
       @Override
       public Void apply(String msg) {
           System.out.println(msg);
           return null;
       }
   }

   public static void main(String[] args) throws Exception {
       ScriptEngineManager m = new ScriptEngineManager();
       ScriptEngine e = m.getEngineByName("nashorn");

       // expose functional interface object as a global var
       e.put("dump", new MyFunc());

       // invoke functional interface object like a function!
       e.eval("dump('hello')");
   }
}