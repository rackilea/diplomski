abstract class StockItem{

     protected abstract double getOrderAmount();


     public String getOrderingList(){
          String result = method(); //can invoke it
     }
}

class StockItemFood extends StockItem{
   @Override
   protected double getOrderAmount(){
      //return the value
   }
}