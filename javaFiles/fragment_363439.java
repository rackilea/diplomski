public class Script {
    public static void main(String[] args) throws ScriptException {
        new ScriptEngineManager().getEngineByName("js")
           .eval("print('Hello from Java\\n');");
        for (ScriptEngineFactory se : new ScriptEngineManager().getEngineFactories()) {
            System.out.println("se = " + se.getEngineName());
            System.out.println("se = " + se.getEngineVersion());
            System.out.println("se = " + se.getLanguageName());
            System.out.println("se = " + se.getLanguageVersion());
            System.out.println("se = " + se.getNames());
        }
    }
}