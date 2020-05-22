public class Item
 {
        String itemName;
        int initialStock;
        int currentStock;

    public int getInitialStock(){

         return initialStock();

    }

    public void setInitialStock(int initialStock){

             this.initialStock=initialStock;

   }
        //Other getters and setters too.
 }


 public class Sword extends Item{

      // You can use Item's methods for the statistics calculation.



 }