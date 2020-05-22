// Access the resource from the classloader
try {
    reader = new InputStreamReader(
        YourServletOrWhateverClass.class.getClassLoader().
            getResourceAsStream("your_javascript_file.js"), 
                Charset.forName("UTF-8")); 
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("JavaScript");
    engine.eval(reader);            

    Invocable inv = (Invocable) engine;
    inv.invokeFunction("your_function");
}
catch(NoSuchMethodException nsme) {
    nsme.printStackTrace();
}
catch(ScriptException se) {
    se.printStackTrace();
}
finally {
    try {
        reader.close();
    }
    catch(IOException ioe) {
        ioe.printStackTrace();
    }
}