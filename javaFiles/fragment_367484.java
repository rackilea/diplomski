ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("ECMAScript");
scriptEngine.put("b1", true);
scriptEngine.put("b2", false);

System.out.println(scriptEngine.eval("b1 || b2"));
System.out.println(scriptEngine.eval("b1 && b2"));