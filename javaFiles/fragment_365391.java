public interface MyLibrary extends Library {

    /**
     * Native library instance.
     */
    MyLibrary INSTANCE = (MyLibrary)Native.loadLibrary("MyLibrary", MyLibrary.class);

    /**
    struct Address{
       int a;
       int b;
    };      
    */

    public class Address extends Structure {
        public int    a;
        public int    b;
        public static class ByReference extends Address implements Structure.ByReference {

        };
        public static class ByValue extends Address implements Structure.ByValue {

        };        
    }; 

    /**
      void func(struct Address *a); 
    */
    void func(Address a);
}