StringBuilder build = new StringBuilder();

    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");

    engine.getContext().setWriter(new CaptureWriter(build));

    try
    {
        engine.eval("print(\"Hello\")");
        engine.eval("print(\"World\")");
        engine.eval("print(\"You\")");
        engine.eval("print(\"There\")");
    } catch(ScriptException e)
    {
        e.printStackTrace();
    }

    System.out.println(build);