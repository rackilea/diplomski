public class A{
    private static A instance = null;
    private A(){} // private constructor
    public static A getInstance() {
        if(instance == null){
           instance = new A(); // create the one instance.
        }
        return instance;
    }
}