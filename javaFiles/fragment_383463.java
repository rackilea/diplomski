package secretgame.scripting;

import java.util.ArrayList;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import secretgame.SecretGameException;
import secretgame.events.EventArgs;
import secretgame.levels.Level;

// sadly this won't work on Android because there's no such thing
// as javax.script in Dalvik ... dumb Android java :|
public class JavaxScriptingLua implements Lua
{
  private ScriptEngine scriptEngine;
  private final Level level;
  private final ScriptTools scriptTools;
  private final ScriptEvents scriptEvents;
  private int nextId = 0;
  private ArrayList<CompiledScript> scripts = new ArrayList<CompiledScript>();

  public JavaxScriptingLua(Level level, ScriptTools scriptTools, ScriptEvents scriptEvents)
  {
    this.level = level;
    this.scriptTools = scriptTools;
    this.scriptEvents = scriptEvents;

    ScriptEngineManager sem = new ScriptEngineManager();
    scriptEngine = sem.getEngineByExtension(".lua");
  }

  public int add(String scriptText) throws SecretGameException
  {
    try {
      CompiledScript script = ((Compilable)scriptEngine).compile(scriptText);
      scripts.add(script);
    }
    catch (ScriptException e) {
      throw new SecretGameException("could not compile lua.", e);
    }

    return nextId++;
  }

  public void run(int id, EventArgs args) throws SecretGameException
  {    
    Bindings bindings = scriptEngine.createBindings();

    bindings.put("java", scriptTools);
    bindings.put("level", level);
    bindings.put("args", args);
    bindings.put("events", scriptEvents);

    try {
      scripts.get(id).eval(bindings);
    }
    catch (ScriptException e) {
      throw new SecretGameException("could not run script.", e);
    }
  }
}