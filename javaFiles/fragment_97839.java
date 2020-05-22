public static void main(String[] args) throws Exception {
    MyWindow.param1.set("paramValue");
    try {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("var MyWindow = Java.type(\"" + MyWindow.class.getName() + "\");" +
                    "print(new MyWindow().test());");
    } finally {
        MyWindow.param1.remove();
    }
}

public class MyWindow {
    public static final ThreadLocal<String> param1 = new ThreadLocal<>();
    public String test() {
        String value = param1.get();
        return "in test: param1 = " + value;
    }
}