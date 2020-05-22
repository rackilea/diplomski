public class ReflectionStatic {

    public static int staticVariable = 5;

    public static void main(String[] args) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
        Class<ReflectionStatic> clazz = ReflectionStatic.class;
        int value = clazz.getField("staticVariable").getInt(null);
        System.out.println(value);
    }
}