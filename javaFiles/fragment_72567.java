public class Cream extends CoffeeDecorator{

   public double cost(){
     return item.cost() + 0.35;
   }

}