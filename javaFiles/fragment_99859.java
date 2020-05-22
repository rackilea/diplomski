import java.util.function.Function;
import javax.script.*;

public class TestFunction {
    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        @SuppressWarnings("unchecked")
        Function<Object,Object> f = (Function<Object,Object>)engine.eval(
            String.format("new java.util.function.Function(%s)", args[0]));
        for (int i = 1; i < args.length; i++) {
            System.out.println(f.apply(args[i]));
        }
    }
}