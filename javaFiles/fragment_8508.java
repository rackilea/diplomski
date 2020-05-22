private static ScriptEngineManager mgr = null;
    private static ScriptEngine engine = null;

    mgr = new ScriptEngineManager();
    engine = mgr.getEngineByName("JavaScript");

    Object eval = engine.eval(s); // s is javascript code