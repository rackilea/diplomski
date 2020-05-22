public interface class FruitVisitor
{
   // etc.

   // Note that there are no visit method for Fruit
   // this is not an error

   public void visit(Apple a) ;
   public void visit(Peach p) ;
}