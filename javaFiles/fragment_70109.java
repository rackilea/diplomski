import jdk.nashorn.api.scripting.*;
import javax.script.*;

public class Main {

  static class MyJSObject extends AbstractJSObject {
    @Override
    public Object getMember(String name) {
      if (name.equals("toString")) {
          // return a "function" object for "toString" property
          return new AbstractJSObject() {
              @Override
              public boolean isFunction() {
                  return true;
              }

              @Override
              public Object call(Object self, Object...args) {
                  return self.toString();
              }
          };
      }
      return null; // other properties here
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