public class MyLib extends TwoArgFunction {
    public static MyLib MYLIB = null;
    public MyLib() {
        MYLIB = this;
    }

public LuaValue call(LuaValue modname, LuaValue env) {
        LuaTable mine = new LuaTable(0,30);
        mine.set("someFunc", new SomeFunc());
        env.set("mine", mine);
        env.get("package").get("loaded").set("mine", mine);
        return mine;
    }
}