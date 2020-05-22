ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("groovy");
engine.eval("int i = 10;\n" +
        "int j = 2;\n" +
        "int k = i*j;\n" +
         "System.out.println(\"Result is \" + k);");