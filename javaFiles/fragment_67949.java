static class Evaluator {
    ScriptEngine engine = new ScriptEngineManager()
        .getEngineByExtension("js");

    void formula(String formula) {
        try {
            engine.eval("function foo() { return " + formula + "; }");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    Object eval(Object values)
            throws ScriptException,
                IllegalArgumentException,
                IllegalAccessException {
        for (Field f : values.getClass().getFields())
            engine.put(f.getName(), f.get(values));
        return engine.eval("foo()");
    }

}

public static class Object1 {
    public double metrics1;
    public double metrics2;
    Object1(double metrics1, double metrics2) {
        this.metrics1 = metrics1;
        this.metrics2 = metrics2;
    }
}

public static void main(String[] args)
    throws ScriptException,
        IllegalArgumentException,
        IllegalAccessException {
    Evaluator e = new Evaluator();
    e.formula("metrics1 + metrics2");
    Object1 object = new Object1(1.0, 2.0);
    System.out.println(e.eval(object));
    // -> 3.0
}