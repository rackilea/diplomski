import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

public class Greeter {

    @JRubyMethod
    public static void greet( ThreadContext context, IRubyObject self ) {
        System.out.printf("Hello from %s%n", self);
    }

}