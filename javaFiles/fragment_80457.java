public abstract class Fruit
{
   // etc.
   public abstract void accept(FruitVisitor v) ;
}

public class Apple extends Fruit
{
   // etc.
   public void accept(FruitVisitor v)
   {
      v.visit(this) ;
   }
}

public class Peach extends Fruit
{
   // etc.
   public void accept(FruitVisitor v)
   {
      v.visit(this) ;
   }
}