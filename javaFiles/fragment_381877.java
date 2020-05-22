// Correct lazy initialization in Java 
@ThreadSafe
class Foo {
    private static class HelperHolder {
       public static Helper helper = new Helper();
    }

    public static Helper getHelper() {
        return HelperHolder.helper;
    }
}