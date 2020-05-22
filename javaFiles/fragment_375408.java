import org.graalvm.polyglot.*;
public class Main {
    public static void main(String[] args) {
        Context polyglot = Context.create();
        Value array = polyglot.eval("js", "[1,2,42,4]");
        System.out.println(array.getArrayElement(2).asInt());
    }
}