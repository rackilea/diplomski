public void testIt() throws Exception {
        final String in = "5W3D10H5M10S";
        final String after = in.replaceAll("W", "*7D").
                replaceAll("D", "*24H").
                replaceAll("H", "*60M").
                replaceAll("M", "*60+").
                replaceAll("S", "");
        final ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("js");
        final Object result = engine.eval(after);
        System.out.println("Result:" + String.valueOf(result));
    }