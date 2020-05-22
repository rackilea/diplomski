package secretgame.scripting;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;

import secretgame.SecretGameException;
import secretgame.events.EventArgs;
import secretgame.levels.Level;

public class DirectLuaj implements Lua
{
  private final Level level;
  private final ScriptTools scriptTools;
  private final ScriptEvents scriptEvents;
  private int nextId = 0;
  private ArrayList<LuaClosure> scripts = new ArrayList<LuaClosure>();

  public DirectLuaj(Level level, ScriptTools scriptTools,
      ScriptEvents scriptEvents)
  {
    this.level = level;
    this.scriptTools = scriptTools;
    this.scriptEvents = scriptEvents;
  }

  @Override
  public int add(String scriptText) throws SecretGameException
  {
    try {
      InputStream input = new ByteArrayInputStream(scriptText.getBytes());
      Prototype p = LuaC.compile(input, "script");
      LuaValue g = JsePlatform.standardGlobals();
      LuaClosure c = new LuaClosure(p, g);
      scripts.add(c);
    }
    catch (IOException e) {
      throw new SecretGameException("compile failed", e);
    }

    return nextId++;
  }

  @Override
  public void run(int id, EventArgs args) throws SecretGameException
  {
    LuaClosure script = scripts.get(id);

    LuaTable bindings = new LuaTable();

    bindings.set("java", toLua(scriptTools));
    bindings.set("level", toLua(level));
    bindings.set("args", toLua(args));
    bindings.set("events", toLua(scriptEvents));

    script.setfenv(bindings);

    script.call();
  }

  private LuaValue toLua(Object javaValue) {
    return javaValue == null? LuaValue.NIL:
            javaValue instanceof LuaValue? (LuaValue) javaValue:
            CoerceJavaToLua.coerce(javaValue);
  }
}