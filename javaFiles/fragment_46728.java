ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
ScriptContext context = engine.getContext();
StringWriter writer = new StringWriter();
context.setWriter(writer);

engine.eval("print('Welocme to java worldddd')");

String output = writer.toString();

System.out.println("Script output: " + output);