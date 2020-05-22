public class Test {

    static class Inner {
        static String trueLiteral = "true";
    }

    public static void main(String[] args) throws Exception {
        Field f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set("true", f.get("false"));

        if ("true" == Inner.trueLiteral) {
            System.out.println("OK");
        } else {
            System.out.println("BUG!");
        }
    }
}