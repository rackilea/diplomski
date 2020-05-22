import java.lang.reflect.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class ReflectionTest {

    private static Object getPrivateStatic(Class clazz, String f) throws Exception {
        Field field = clazz.getDeclaredField(f);
        field.setAccessible(true);
        return field.get(null);
    }

    private static void a(Class paramClass, String paramString, int paramInt) {
        try {
            ((Map) getPrivateStatic(sg.class, "c")).put(paramString, paramClass);
            //...
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        a(String.class, "test", 0);
        sg.printC();
    }
}

class sg {
    private static Map c = new HashMap();
    private static Map d = new HashMap();
    private static Map e = new HashMap();
    private static Map f = new HashMap();
    private static Map g = new HashMap();
    public static HashMap a = new LinkedHashMap();

    public static void printC() {
        System.out.println(c);
    }
}