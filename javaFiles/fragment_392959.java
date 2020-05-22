public class TestMeTester {

    public static class TestMe {
        private Map<String, String> testMap = new HashMap<String, String>();
    }

    public static void main(String[] args) throws IllegalArgumentException,
        IllegalAccessException, SecurityException, NoSuchFieldException {
        TestMe obj = new TestMe();
        Class clazz = obj.getClass();
        Field field = clazz.getDeclaredField("testMap");
        field.setAccessible(true);
        Map<String, String> refMap = (HashMap<String, String>) field.get(obj);
        System.out.println("==>" + refMap);
    }
}