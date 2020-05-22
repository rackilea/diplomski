public class Test {
    public static void main(String[] args) throws IOException,ReflectiveOperationException{
        byte[] code;
        try(InputStream is = Test.class.getResourceAsStream("Test.class")) {
            code = ConvertToInvokeDynamic.convertInvokeVirtual(is,
                LinkLikeInvokeVirtual.class.getName(), "bootstrap");
        }
        Class<?> transformed = new ClassLoader() {
            Class<?> get() {return defineClass("Test", code, 0, code.length); }
        }.get();
        transformed.getMethod("example").invoke(null);
    }

    public static void example() {
        System.out.println(Runtime.getRuntime().freeMemory()+" bytes free");
    }
}