ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
ScriptContext context = engine.getContext();
StringWriter writer = new StringWriter();
context.setWriter(writer);

engine.eval("print(" + a + b + c + ")");

String output = ;
System.out.println("Script result: " + writer.toString());