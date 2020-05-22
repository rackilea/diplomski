public class Demo {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.mycompany.mypackage.Demo");
        Demo d = (Demo) clazz.newInstance();
    }
}