import java.lang.invoke.*;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Field;
import java.util.function.BiFunction;

public class Test {
    public static void main(String[] args) throws Throwable {
        // Reflectively generate a TRUSTED Lookup for the String class
        Lookup caller = MethodHandles.lookup().in(String.class);
        Field modes = Lookup.class.getDeclaredField("allowedModes");
        modes.setAccessible(true);
        modes.setInt(caller, -1);   // -1 == Lookup.TRUSTED
        // create handle for shared String constructor
        MethodHandle constructor = caller.findConstructor(
            String.class, MethodType.methodType(void.class, char[].class, boolean.class)
        );
        // generate interface implementation for constructor
        BiFunction<char[],Boolean,String> shared=getStringCreator(caller, constructor);

        // test if the construcor is correctly accessed
        char[] chars = "foo".toCharArray();
        String s = shared.apply(chars, true);
        chars[0] = 'b'; chars[1] = 'a'; chars[2] = 'r';// modify array contents
        System.out.println(s); // prints "bar"
        chars[0] = '1'; chars[1] = '2'; chars[2] = '3';
        System.out.println(s); // prints "123"
    }
    private static BiFunction<char[],Boolean,String> getStringCreator(
            Lookup caller, MethodHandle handle) throws Throwable {
        CallSite callSite = LambdaMetafactory.metafactory(
            caller,
            "apply",
            MethodType.methodType(BiFunction.class),
            handle.type().generic(),
            handle,
            handle.type()
        );
        return (BiFunction) callSite.getTarget().invokeExact();
    }
}