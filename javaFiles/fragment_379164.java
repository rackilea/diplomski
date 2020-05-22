public abstract class Foo <E extends Foo<E>> 
{

   public static void use(Foo<E> foo) {
      // use foo
   }
}