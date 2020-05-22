public static void main(String[] args) throws Throwable {
        String script = "say \"Hello from Java\"";

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("AppleScriptEngine");
        engine.eval(script);
    }