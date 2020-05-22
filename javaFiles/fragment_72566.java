public class Mocha extends CoffeeDecorator{

   public double cost(){
     return item.cost() + 0.5;
   }

}