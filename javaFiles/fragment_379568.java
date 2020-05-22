public class BService extends AService<B> {

   // The type is checked by the compiler; anyone trying to pass an instance
   // of A into this class would get a compile-time exception (not a class cast
   // at runtime)
   public int getValue(B b) {
       return b.getB1();
   }
}