import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import static net.bytebuddy.matcher.ElementMatchers.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SomeKey someKey = new SomeKey("my", "key");
        System.out.println(someKey); // :<
        // this class should be cached/saved somewhere, do not create new one each time.
        Class<? extends SomeKey> loaded = new ByteBuddy()
                .subclass(SomeKey.class)
                .method(named("toString").and(returns(String.class).and(takesArguments(0))))
                .intercept(FixedValue.value("something"))
                .make()
                .load(Main.class.getClassLoader()).getLoaded();
        someKey = loaded.getConstructor(String.class, String.class).newInstance("what", "ever");
        System.out.println(someKey); // YeY
    }
}
class SomeKey {
    final String group;
    final String name;
    public SomeKey(String group, String name) {
        this.group = group;
        this.name = name;
    }
    public String getGroup() { return this.group; }
    public String getName() { return this.name; }
    @Override public String toString() {
        return group+":"+name;
    }
}