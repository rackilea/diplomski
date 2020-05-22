String runJs() throws Throwable {

    StringWriter scriptWriter = new StringWriter();
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    ScriptContext scriptContext = engine.getContext();
    scriptContext.setWriter(scriptWriter);
    Server server = new Server(engine, new Loader.Core(), new Logging(false), System.getProperty("user.dir"));
    server.run("js/hello-world.js");

    return scriptWriter.toString();
}