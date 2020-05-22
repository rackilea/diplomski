public class Apple extends Fruit implements IsPriceChecking{
   public void checkPrice(){
    if(this.price>2)
        System.out.print("  --  This apple is too expensive!");
    else
        System.out.print("  --  This apple is cheap.");
  }
}