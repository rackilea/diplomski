import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    private Map ttp = new HashMap(); 

    public  void test() {
        Field declaredField =  null;
        try {

            declaredField = Test.class.getDeclaredField("ttp");
            boolean accessible = declaredField.isAccessible();

            declaredField.setAccessible(true);

            ConcurrentHashMap<Object, Object> concHashMap = new ConcurrentHashMap<Object, Object>();
            concHashMap.put("key1", "value1");
            declaredField.set(this, concHashMap);
            Object value = ttp.get("key1");

            System.out.println(value);

            declaredField.setAccessible(accessible);

        } catch (NoSuchFieldException 
                | SecurityException
                | IllegalArgumentException 
                | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... args) {
        Test test = new Test();
        test.test(); 
    }
}