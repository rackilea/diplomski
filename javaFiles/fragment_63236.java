public void executeScript(String scriptName, String[] dependencies) {
    try {
        FileReader script = new FileReader(scriptName);
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine jsEngine = factory.getEngineByName("nashorn");

        if(dependencies != null) {
            for (String dependency : dependencies) {
                FileReader dependencyFile = new FileReader(dependency);
                jsEngine.eval(dependencyFile);
            }
        }

        jsEngine.eval(script);
    }
}