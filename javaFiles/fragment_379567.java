public class AService<T extends A> {

   // Now this takes a T - i.e. the type that a subclass is parameterised on
   public abstract int getValue(T a)

   // Execute will have to take a T as well to pass into getValue - an A
   // wouldn't work as it might not be the right type
   public int execute(T a)
   {
      return a.getA1() + getValue(a);
   }
}