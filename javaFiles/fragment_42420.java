import javax.script.*;

public class ScriptDemo {
  public static class Bar {
    public String bar = "bar";
  }

  public static void main(String[] args) throws ScriptException {
    ScriptEngine engine =
                         new ScriptEngineManager().getEngineByName("JavaScript");
    engine.put("foo", "foo");
    engine.put("bar", new Bar());
    engine.eval("println(typeof foo);");
    engine.eval("println(typeof bar.bar);");
    engine.eval("println(typeof String(bar.bar));");
    engine.eval("println(typeof new String(bar.bar));");
  }
}