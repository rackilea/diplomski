public class MyClass {  
    protected static final Setter setter;

    static {
        try { 
            setter = new Setter();
        } catch (FileNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}