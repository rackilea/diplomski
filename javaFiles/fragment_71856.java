import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineTest {
  public static void main(String[] args) {
    final ScriptEngineManager mgr = new ScriptEngineManager();
    for(ScriptEngineFactory fac: mgr.getEngineFactories()) {
      System.out.println(String.format("%s (%s), %s (%s), %s", fac.getEngineName(),
          fac.getEngineVersion(), fac.getLanguageName(),
          fac.getLanguageVersion(), fac.getParameter("THREADING")));
    }
  }
}