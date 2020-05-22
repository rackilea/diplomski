public class Foo
{
   public wash(Apple a) { /* etc. */ }
   public wash(Peach p) { /* etc. */ }
   public bar(List<? extends Fruit> arguments)
   {
      for( Fruit f: arguments)
      {
         wash(f) ; // we wand the right wash method called.
      }
   }
}