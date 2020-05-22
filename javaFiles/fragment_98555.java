public class Test {

    public static void callPrint(String className){
        try {
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            clazz.getDeclaredMethod("print").invoke(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        callPrint("test.A");
        callPrint("test.B");
    }
}