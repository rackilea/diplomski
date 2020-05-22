ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
ScriptEngine scriptEngine = scriptEngineManager.getEngineByName(engineName);
final CompiledScript compiled = ((Compilable) scriptEngine).compile(script);
Bindings bindings = scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);
bindings.put("key", value);
compiled.eval(bindings);