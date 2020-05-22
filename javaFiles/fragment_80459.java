public class FruitVisitorWasher : implements FruitVisitor
{
   // etc.

   // Note that there are no visit method for Fruit
   // this is not an error

   // Note, too, that you must provide a wash method in
   // FruitVisitorWasher (or use an anonymous class, as
   // in the example of the second edit to access the
   // wash method of the outer class)

   public void visit(Apple a)
   {
      wash(a) ;
   }

   public void visit(Peach p)
   {
      wash(p) ;
   }
}