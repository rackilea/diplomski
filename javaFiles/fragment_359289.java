import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import jdk.nashorn.api.scripting.AbstractJSObject;
import java.util.function.Supplier;

public class Foo extends AbstractJSObject {
    String bar;

    public Foo() {
        super();
    }

    public Foo(String b) {
        super();
        this.bar = b;
    }

    @Override
    public Object newObject(Object... args) {
        String bar = null;
        if (args[0] != null) bar = args[0].toString();

        Foo f = new Foo(bar);
        return f;
    }

    @Override
    public Object getMember(String name) {
        if (name.equals("toString")) {
            // Returning a lambda function as value of this property.
            // nashorn code can call lambdas just like script functions!
            // You may also choose to return another JSObject that
            // returns true in isFunction() method and implements "call"
            // as well.

            return (Supplier<String>)this::toString;
        } else {
            // implement other exposed properties here.
            return null;
        }
    }

    @Override
    public String toString() {
        return "Foo: " + this.bar;
    }


    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new  ScriptEngineManager().getEngineByName("nashorn");
        engine.put("foo", new Foo());

        // f.toString() would call getMember("toString") and the
        // returning lambda is called!

        engine.eval("var f = new foo('hi'); print(f.toString());");
    }
}