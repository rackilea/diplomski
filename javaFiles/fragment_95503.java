public class TestCast {

    public static class MyMap extends HashMap<String, String> {
    }

    public static <T> Map<T,String> getMap1(Class<?> myClass) {
        return new HashMap<T,String>();
    }

    public static <T> Map<T,String> getMap2(Class<T> myClass) {
        return new HashMap<T,String>();
    }

    public static void main(String[] args) {

        // Works, because it knows T is String as you state it with the variable type Map<STRING,String>
        Map<String,String> map = getMap(String.class); 

        // Compilation error, it doesn't know T is String and cast won't work either
        MyMap myMap = getMap1(String.class); 

        // Works, because it knows T is String as it is getting it in the method parameter, no need to rely on the variable that is getting the value
        MyMap myMap = (MyMap) getMap2(String.class); 
    }

}