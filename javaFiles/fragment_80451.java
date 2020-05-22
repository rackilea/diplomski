public class Test {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        System.out.println(test.test(false, false));
        System.out.println(test.test(false, true ));
        System.out.println(test.test(true , false));
        System.out.println(test.test(true , true ));
    }

    private ScriptEngine   jsEngine;
    private CompiledScript script;

    private Test() throws ScriptException {
        this.jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        this.script = ((Compilable) this.jsEngine).compile("in1 && in2");
    }

    private boolean test(boolean in1, boolean in2) throws ScriptException {
        Bindings vars = this.jsEngine.createBindings();
        vars.put("in1", in1);
        vars.put("in2", in2);
        return (boolean) this.script.eval(vars);
    }
}