import java.lang.reflect.Field;

    public class TestReflection {

        public static final String key1 = "newKey";

        public static void main(String[] args) throws SecurityException,
                NoSuchFieldException, IllegalArgumentException,
                IllegalAccessException, ClassNotFoundException {
            checkKey("newKey");
            checkKey("TestReflection.key1");
        }

        private static void checkKey(String str) throws NoSuchFieldException,
                IllegalAccessException, ClassNotFoundException {
            String[] str1 = str.split("\\.");
            if (str1.length == 1) {
                System.out.println(str1[0]);
            } else if (str1.length == 2) {
                Field value = Class.forName(str1[0]).getField(str1[1]);
                value.setAccessible(true);
                System.out.println(value.get(null));
            }
        }
    }