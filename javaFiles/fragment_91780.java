package luaj;

import org.luaj.vm2.*;
import org.luaj.vm2.lib.*;
import org.luaj.vm2.lib.jse.*;

public class luaj {

    static final public class MyClass {

        public static int asd = 5;

        static public class Test extends ZeroArgFunction {

            @Override
            public LuaValue call() {
                System.out.println("Worked");
                return NIL;
            }
        }
    }

    public static void main(String[] args) {
        Globals globals = JsePlatform.standardGlobals();
        LuaValue test = CoerceJavaToLua.coerce(new MyClass());
        globals.set("obj", test);
        LuaTable t = new LuaTable();
        t.set("test", new MyClass.Test());
        t.set("__index", t);
        test.setmetatable(t);
        LuaValue chunk = globals.load("print('Testing', obj.asd) obj.test()");
        chunk.call();
    }
}