import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JsTest {

  @org.junit.Test
  public void test() throws Exception  {
    ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("nashorn");
    jsEngine.eval("var say = function(name) {return 'Hello ' + name;}");

    Invocable jsScript = (Invocable) jsEngine;

    Object result = jsScript.invokeFunction("say", "XYZ");
    System.out.println(result);
  }
}