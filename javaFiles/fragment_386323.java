public class MathLib extends OneArgFunction {
    public static MathLib MATHLIB = null;
    public MathLib() {
        MATHLIB = this;
    }

    public LuaValue call(LuaValue env) {
        LuaTable math = new LuaTable(0,30); // I think "new LuaTable()" instead of "(0, 30)" is OK
        math.set("abs", new abs());
        math.set("max", new max());
        env.set("math", math);
        env.get("package").get("loaded").set("math", math);
        return math;
    }
}