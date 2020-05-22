import jdk.nashorn.api.scripting.ScriptObjectMirror;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    public static class TestObj {

        public TestObj() {

        }
        public void setVariable(String name, Object value) {
            System.out.println(name + ":" + value);
            if (value instanceof ScriptObjectMirror) {
                ScriptObjectMirror scriptObjectMirror = (ScriptObjectMirror) value;
                String[] ownKeys = scriptObjectMirror.getOwnKeys(true);
                for (String k: ownKeys) {
                    System.out.println(scriptObjectMirror.get(k));
                }
            }
        }
    }

    public static void main(String[] args) throws ScriptException {
        System.out.println("Hello World!");


        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine engine = scriptEngineManager.getEngineByName("javascript");
        String js = "var transform = {\n" +
                "execute : function(execution) {\n" +
                "    print(\"hello\");" +
                "execution.setVariable(\"test\",\"testing\");\n" +
                "    function transform(execution) {\n" +
                "        execution.setVariable(\"result\", {result:\"myjson object\"});\n" +
                "        print(\"Testing\");\n" +
                "    }\n" +
                "    return transform;\n" +
                "}}";
        System.out.println(engine);
        engine.eval(js);
        //engine.put("execution", new TestObj());
        ScriptObjectMirror transform = (ScriptObjectMirror) engine.get("transform");
        ScriptObjectMirror execute = (ScriptObjectMirror) transform.callMember("execute", new TestObj());
        execute.call(execute,new TestObj());
        System.out.println("fully working code");
    }
}