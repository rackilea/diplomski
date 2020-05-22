public class Foo
{
   public void wash(Apple a) { System.out.println("Apple") ; }
   public void wash(Peach p) { System.out.println("Peach") ; }

   public void bar(List<? extends Fruit> arguments)
   {
      FruitVisitor fv = new FruitVisitor()
      {
         public void visit(Apple a)
         {
            wash(a) ; // will call the wash method
                      // of the outer class (Foo)
         }

         public void visit(Peach p)
         {
            wash(p) ; // will call the wash method
                      // of the outer class (Foo)
         }
      } ;

      for(Fruit f: arguments)
      {
         f.accept(fv) ;
      }
   }
}