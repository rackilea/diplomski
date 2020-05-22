import jdk.nashorn.api.scripting.*;
import javax.script.*;

public class Main2 {

  static class MyJSObject extends AbstractJSObject {
    @Override
    public Object getDefaultValue(Class<?> hint) {
        if (hint == String.class) {
            return toString();
        }
        throw new UnsupportedOperationException("no conversion for " + hint);
    }

    @Override 
    public String toString() {
        return "my js object";
    }
  }

  public static void main(String[] a) throws Exception {
    ScriptEngineManager m = new ScriptEngineManager();
    ScriptEngine e = m.getEngineByName("nashorn");
    e.put("myObj", new MyJSObject());
    e.eval("print(myObj)");
  }
}