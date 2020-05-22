import java.lang.reflect.*;

class Other {
    private static void privateMethod() {
        System.out.println("You can't call me, can you?");
    }
}

public class Test {
    public static void main (String[] args) throws Exception {
        Method method = Other.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        method.invoke(null);
    }
}